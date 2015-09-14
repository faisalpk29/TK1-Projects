/**
 * 
 */
package com.tk1.soap;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.tk1.util.ClientInterface;





/**
 * @author Faisal Arshad
 *
 */
public class SoapClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			 	JFrame mainFrame = new JFrame();      
			 	mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		        ClientInterface mainPanel = new ClientInterface("soap");
		        mainFrame.setTitle("Soap Client - JAX-WS");
		        mainFrame.setResizable(false);
		        mainFrame.setLayout(new BorderLayout());
		        mainFrame.add(mainPanel, BorderLayout.CENTER);
		        mainFrame.pack();
		        mainFrame.setVisible(true);  

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	

	}

}
