/**
 * 
 */
package tu.edu.tk1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Faisal Arshad
 *
 */
public interface HuntServer extends Remote {
	String login(HuntClientInterface client) throws RemoteException;
	void logout(HuntClientInterface client) throws RemoteException;
	void huntFly(HuntClientInterface client) throws RemoteException;

}
