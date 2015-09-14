package com.tk1.view.client1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartClient1 {
	
	public StartClient1() {
		 System.out.println("New Client....");
		
	 }

	public static void main(String[] args) {
	    	Client1Gui gui = new Client1Gui("1") ;
	    	JFrame gui1 = new JFrame("Hunt Fly JMS Client 1 ...");            
	    	gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        gui1.setResizable(false);
	        gui1.setLayout(new BorderLayout());
	        gui1.add(gui, BorderLayout.CENTER);
	        gui1.pack();
	        gui1.setVisible(true); 
	        
	        
	        
	    
		
	    }
	
	    
	    
}
