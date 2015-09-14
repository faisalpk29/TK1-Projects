package com.tk1.jms;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import com.tk1.controller.ControllerClient2;
import com.tk1.controller.Util;



public class JMSClient2 implements javax.jms.ExceptionListener,MessageListener {

	ActiveMQConnectionFactory connectionFactory = null;
	private  String queue1 ;
	private  String queue2;
	private String activeMqURL;
	private ControllerClient2 ctrler2;
	private List<String>  flyIds ;
	

	public JMSClient2(ControllerClient2 controller) {
		super();
		this.ctrler2 = controller;
		this.flyIds = new ArrayList<>();
		 init();
		 
		 startConsumer(connectionFactory);
		 Util.println("******************JMSClient2*******************");
	}

	

	@Override
	public void onException(JMSException exception) {
		 System.out.println("JMS Exception occured.  Shutting down client."+exception.getMessage());
		
	}

	private void startConsumer(ActiveMQConnectionFactory connectionFactory ){
		try {
			
			Connection connection = connectionFactory.createConnection();
			connection.start();
			connection.setExceptionListener(this);
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			ActiveMQTopic topic = new ActiveMQTopic(queue1);
			//Destination destination = session.createTopic(queue1);
			MessageConsumer consumer = session.createConsumer(topic,null,true);
			consumer.setMessageListener(this);
			


		} catch (Exception e) {
			Util.println("Caught: " + e);
			e.printStackTrace();
		}

	}
	
	public void sendMessage(FlyInfo fly){
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			ActiveMQTopic topic =  new ActiveMQTopic(queue2);
			//Destination destination = session.createTopic(queue2);
			
			MessageProducer producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			ObjectMessage objMessage= session.createObjectMessage(fly);
			producer.send(objMessage);

			

		
			session.close();
			connection.close();
		}
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
	}
	@Override
	public void onMessage(Message message) {
		
		//Util.println("onMessage Client2--- ");
		try {
			
			if (null != message && message instanceof ObjectMessage) {
					ObjectMessage objMsg = (ObjectMessage) message;
					FlyInfo fly = (FlyInfo) objMsg.getObject();
					Util.println("****************Client 2 2 2 *****************"+fly.getFlyId());
					ArrayList<FlyInfo>list = fly.getFlyList();
					if(null!=list){
						for (FlyInfo flyInfo : list) {
							if (null!=flyInfo) {
								Util.println("Flies from client 1 ["+flyInfo.getFlyId()+"]");
							}
						}
					}
					if ((fly.getOperation().equals("UPDATE") ||fly.getOperation().equals("START") )
							&& !flyIds.contains(fly.getFlyId())) {
						Util.println("not in list of client 2 going to update ");
						flyIds.add(fly.getFlyId());
						ctrler2.updateGui(fly);
					}else if(fly.getOperation().equals("REMOVE") ){
						//flyIds.remove(fly.getFlyId());
						ctrler2.removeFly(fly);
						
					}
				}

			
			
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
	
	
	private void init(){
		try {
			
			FileReader propReader = new FileReader("config.properties");
			Properties prop = new Properties();
			prop.load(propReader);
			setQueue1(prop.getProperty("queue1"));
			setQueue2(prop.getProperty("queue2"));
			setActiveMqURL(prop.getProperty("activeMqURL"));
			Util.println("Configuration Loaded : ....");
			connectionFactory = new ActiveMQConnectionFactory(activeMqURL);
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String getQueue1() {
		return queue1;
	}

	public void setQueue1(String queue1) {
		this.queue1 = queue1;
	}

	public String getQueue2() {
		return queue2;
	}

	public void setQueue2(String queue2) {
		this.queue2 = queue2;
	}

	public String getActiveMqURL() {
		return activeMqURL;
	}

	public void setActiveMqURL(String activeMqURL) {
		this.activeMqURL = activeMqURL;
	}
	
	

}
