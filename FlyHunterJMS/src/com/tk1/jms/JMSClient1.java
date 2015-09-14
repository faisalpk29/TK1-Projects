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
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import com.tk1.controller.Controller;
import com.tk1.controller.Util;



public class JMSClient1 implements javax.jms.ExceptionListener,MessageListener {

	ActiveMQConnectionFactory connectionFactory = null;
	private String queue1;
	private String queue2;
	private String activeMqURL;
	private Controller controller;
	private List<String>flyIds ;
	
	public JMSClient1(Controller contrlr) {
		
		super();
		this.controller = contrlr;
		this.flyIds = new ArrayList<>();
		 init();
		 connectionFactory = new ActiveMQConnectionFactory(activeMqURL);
		 startConsumer(connectionFactory);
		 Util.println("******************JMSClient1*******************");
	}

	
	

	@Override
	public void onException(JMSException exception) {
		 Util.println("JMS Exception occured.  Shutting down client."+exception.getMessage());
		
	}

	private void startConsumer(ActiveMQConnectionFactory connectionFactory ){
		try {
			
			Connection connection = connectionFactory.createConnection();
			connection.start();
			connection.setExceptionListener(this);
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			ActiveMQTopic topic = new ActiveMQTopic(queue2);
			//Destination destination = session.createQueue(queue2);
			MessageConsumer consumer = session.createConsumer(topic, null, true);
			consumer.setMessageListener(this);
			//System.err.println("Consumer 1: Started ...... ");

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
			ActiveMQTopic topic = new ActiveMQTopic(queue1);
			//Destination destination = session.creat(queue1);
			MessageProducer producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			ObjectMessage objMessage= session.createObjectMessage(fly);
			producer.send(objMessage);
		
		

			// Clean up
			session.close();
			connection.close();
		}
        catch (Exception e) {
            Util.println("Caught: " + e);
            e.printStackTrace();
        }
	}



	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		Util.println("onMessage Client1 --- ");
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text;

				text = textMessage.getText();
				Util.println("Received: " + text);

			}else if (null != message && message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage) message;
				FlyInfo fly = (FlyInfo) objMsg.getObject();
				Util.println("****************Client 1111 *****************");
			
				Util.println(fly.getFlyId());
				
				
				if (fly.getOperation().equals("UPDATE")  && !flyIds.contains(fly.getFlyId()) ) {
					Util.println("not in list of client 1 going to update ");
					flyIds.add(fly.getFlyId());
					controller.updateGui(fly);
				}else if(fly.getOperation().equals("REMOVE") ){
					flyIds.remove(fly.getFlyId());
					controller.removeFly(fly);
					
				}
			}

			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
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
