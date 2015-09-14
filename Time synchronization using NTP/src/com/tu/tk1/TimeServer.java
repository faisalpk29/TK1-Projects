package com.tu.tk1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class TimeServer {
	private static int PORT = 8838;
	private ServerSocket serverSocket;
	private int artificialOffset=1000;

ObjectOutputStream outToClient;
ObjectInputStream inFromClient;

	public TimeServer() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port: " + PORT);
			
			while(true){
				
	        	NTPRequestHandler handler=new NTPRequestHandler(serverSocket.accept());
	        	Thread t=new Thread(handler);
	        	t.start();
			
			}

		} catch (IOException e) {
			e.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void threadSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TimeServer();
	}

	private class NTPRequestHandler implements Runnable {
		private Socket client;

		public NTPRequestHandler(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			///
			try {
				outToClient = new ObjectOutputStream(
						this.client.getOutputStream());
				inFromClient = new ObjectInputStream(
						this.client.getInputStream());
				NTPRequest serNTPRequest = (NTPRequest) inFromClient
						.readObject();
				serNTPRequest.setT2(System.currentTimeMillis() + artificialOffset);
				// Sleeping for Random delay between 10 and 100 before sending
				// reply to Client
				threadSleep((10 + (int) (Math.random() * ((100 - 10) + 1))));

				sendNTPAnswer(serNTPRequest);

			} catch (IOException | ClassNotFoundException e) {
	e.printStackTrace();
}

		}

		private void sendNTPAnswer(NTPRequest request) throws IOException {
	
			//stamp T3 before sending reply to client
			request.setT3(System.currentTimeMillis()+artificialOffset);
			outToClient.writeObject(request);
		}

	}

}
