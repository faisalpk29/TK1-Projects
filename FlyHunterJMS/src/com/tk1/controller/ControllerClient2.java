/**
 * 
 */
package com.tk1.controller;


import com.tk1.jms.FlyInfo;
import com.tk1.jms.JMSClient2;

import com.tk1.view.client2.Client2Gui;
/**
 * @author Faisal Arshad
 *
 */
public class ControllerClient2 {

		
		JMSClient2 client2 = null;
		String clientId ;
		Client2Gui gui ;

		
		public String getClientId() {
			return clientId;
		}


		public void setClientId(String clientId) {
			this.clientId = clientId;
		}


		public ControllerClient2(Client2Gui ui) {
			
			
			this.gui = ui;
			client2 = new JMSClient2(this);
		
			
		}

		public int huntFly(FlyInfo fly){
			client2.sendMessage(fly);
			return 1;
		}
		
		
		
	public void updateGui(FlyInfo fly){
		this.gui.updateFlise(fly);
		
	}
	public void updateClient1Flies(FlyInfo fly){
		client2.sendMessage(fly);
	}
	public void removeFly(FlyInfo fly){
		this.gui.removeFly(fly);
		
	}

	
}
