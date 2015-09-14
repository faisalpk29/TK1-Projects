package com.tk1.controller;

import com.tk1.jms.FlyInfo;
import com.tk1.jms.JMSClient1;
import com.tk1.jms.JMSClient2;
import com.tk1.view.client1.Client1Gui;

public class Controller {


	JMSClient1 client = null;
	
	String clientId ;
	Client1Gui gui ;

	
	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public Controller(Client1Gui ui) {
		super();
		// TODO Auto-generated constructor stub
		
		this.gui = ui;
		
			client = new JMSClient1(this);
		
		
	}


	public int huntFly(FlyInfo fly){
	
			client.sendMessage(fly);
		
		 
			return 1;
	}
	
	public void updateClient2Flies(FlyInfo fly){
		
		
			client.sendMessage(fly);
		
	}
	
public void updateGui(FlyInfo fly){
	this.gui.updateFlise(fly);
	
}
public void removeFly(FlyInfo fly){
	this.gui.removeFly(fly);
	
}


}
