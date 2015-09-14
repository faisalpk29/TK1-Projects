package com.tu.tk1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
	private static String hostUrl = "127.0.0.1";
	private static int PORT = 8838;
	private long minD;
	private double offsetOfMinD;
	private NTPRequest request;
	private Socket socket;
	ObjectOutputStream outToServer;
	ObjectInputStream inFromServer;
	double[] offsets = new double[10];
	Long[] delays	= new Long[10];
	
	

	public TimeClient() throws InterruptedException, ClassNotFoundException {
		request=new NTPRequest();
		
		try {

			for (int i = 0; i < 10; i++) {
				socket = new Socket(InetAddress.getByName(hostUrl), PORT);
				outToServer = new ObjectOutputStream(socket.getOutputStream());
		        inFromServer = new ObjectInputStream(socket.getInputStream());
				
				sendNTPRequest(request);
				
				request=(NTPRequest)inFromServer.readObject();
				request.setT4(System.currentTimeMillis());
				offsets[i]=request.calculateOffset();
				delays[i]= request.calculateDelay();
				
				System.out.print("\n"+(i+1)+".\t"+"Offset  ["+offsets[i]+"]"+"\t Delay ["+delays[i]+"]");

				socket.close();
				threadSleep(500);
			
			}

			minD  = delays[0];
			 for(int i = 1;i<delays.length;i++){
	                if(delays[i]<minD){
	                	minD = delays[i];
	                	offsetOfMinD = offsets[i];
	                }
	                }
			System.out.print("\nMinimum Delay : "+minD);
			System.out.println("\tCorresponding offset : "+offsetOfMinD);
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	private void sendNTPRequest(NTPRequest request) throws IOException {
		//
		request.setT1(System.currentTimeMillis());
		//Sleeping for Random delay between 10 and 100 before sending request to Server
		threadSleep((10 + (int)(Math.random() * ((100 - 10) + 1))));
		outToServer.writeObject(request);
		

	}

	private void threadSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		new TimeClient();
	}
	
	

}
