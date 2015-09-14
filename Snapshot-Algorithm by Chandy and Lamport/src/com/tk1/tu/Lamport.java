package com.tk1.tu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.tk1.tu.ReceiveObserver.MessageListener;

public class Lamport implements MessageListener
{
   private final static int OBSERVER_PORT = 5555;
   private final static int ACCOUNT1_PORT = 5551; 
   private final static int ACCOUNT2_PORT = 5552;
   private final static int ACCOUNT3_PORT = 5553;
   private GUI gui = null;
   private DatagramSocket socket = null;
   
   public Lamport() throws SocketException
   {
      gui = new GUI(this);
      gui.setVisible(true);
      gui.setResizable(false);
      
      ReceiveObserver observer = new ReceiveObserver(OBSERVER_PORT, this);
      new Thread(observer).start();
      
    
      socket = new DatagramSocket();
   }
   
   public void startBankAccounts(int acc1balance, int acc2balance, int acc3balance)
   {
      
      Account account1 = null, account2 = null, account3 = null;
      try
      {
         account1 = new Account(
               ACCOUNT1_PORT,OBSERVER_PORT,
               ACCOUNT2_PORT,ACCOUNT3_PORT,acc1balance);
         account2 = new Account(
               ACCOUNT2_PORT,OBSERVER_PORT,
               ACCOUNT1_PORT,ACCOUNT3_PORT,acc2balance);
         account3 = new Account(
               ACCOUNT3_PORT,OBSERVER_PORT,
               ACCOUNT1_PORT,ACCOUNT2_PORT,acc3balance);
      } 
      catch (IOException e)
      {
         System.err.println("Failed to create new Bank account: ");
         e.printStackTrace();
      }
      
      new Thread(account1).start(); 
      new Thread(account2).start();
      new Thread(account3).start();
   }
   
   public void startSnapshot(int accountID)
   {
      if (accountID >=1 && accountID <=3)
      {
         byte[] buffer = new byte[1024];
         String message = "startsnapshot;";
         
         // send account packet
         buffer = message.getBytes();
         DatagramPacket packet = null;
         try
         {
            packet = new DatagramPacket(
                  buffer, 
                  buffer.length,
                  InetAddress.getLocalHost(),
                  getAccountPort(accountID));
            
            socket.send(packet);
         } 
         catch (UnknownHostException e)
         {
            e.printStackTrace();
         } 
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }
   }
   
   private int getAccountPort(int accountID)
   {
      int ret = (accountID == 1) ? ACCOUNT1_PORT : 
                  ((accountID == 2) ? ACCOUNT2_PORT : 
                     ((accountID == 3) ? ACCOUNT3_PORT : -1));
      return ret;
   }
   
   @Override
   public void onMarker(String from, String to)
   {
      gui.printMsg("Mark: " + from + " -> " + to);
   }

   @Override
   public void onTransaction(String from, String to, String amount)
   {
     
      int fromAcc = Integer.parseInt(from.substring(7));
      int toAcc = Integer.parseInt(to.substring(7));
      
      int tmpAmount = (int) Double.parseDouble(amount);
      
      int fromAccBalance = gui.get_Share(fromAcc) - tmpAmount;
      int toAccBalance = gui.get_Share(toAcc) + tmpAmount;
      

            
      gui.set_Account(fromAcc, fromAccBalance);
      gui.set_Account(toAcc, toAccBalance);
      
     
      String msg = "Transfer: " + from + " -> " + to + " [" + tmpAmount + " ]";
      gui.printMsg(msg);

   }
   
   @Override
   public void onSnapshotInfo(String from, String snapshotMsg)
   {
      gui.printMsg(from + " <" + snapshotMsg + ">");
      
   }
   
   /**
    * @param args
    */
   public static void main(String[] args)
   {
      try
      {
         new Lamport();
      } 
      catch (SocketException e)
      {
         System.err.println("Initialization Error: " + e.getMessage());
      }
   }
}