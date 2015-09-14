package tu.edu.tk1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	 public static void main(String args[]) {
	
			try {
				HuntServerImpl obj = new HuntServerImpl();
			  
			  
			    Registry registry = LocateRegistry.createRegistry(1300);
			    registry.rebind("HuntServer", obj);

			    System.err.println("Server ready");
			} catch (Exception e) {
			    System.err.println("Server exception: " + e.toString());
			    e.printStackTrace();
			}
		    }
}
