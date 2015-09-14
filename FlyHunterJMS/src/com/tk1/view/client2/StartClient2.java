package com.tk1.view.client2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartClient2 {
	
	public StartClient2() {
		 System.out.println("New Client....");
		
	 }

	public static void main(String[] args) {
	       
	        Client2Gui gui2 = new Client2Gui() ;
	    	JFrame mainFrame2 = new JFrame("Hunt Fly JMS Client 2 ...");            
	    	mainFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        mainFrame2.setResizable(false);
	        mainFrame2.setLayout(new BorderLayout());
	        mainFrame2.add(gui2, BorderLayout.CENTER);
	        mainFrame2.pack();
	        mainFrame2.setVisible(true); 
	        
	        
	        
		
		
	    }
	
	    
	    
}
