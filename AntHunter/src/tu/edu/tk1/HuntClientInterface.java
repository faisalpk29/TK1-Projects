/**
 * 
 */
package tu.edu.tk1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * @author Faisal Arshad
 *
 */
public interface HuntClientInterface extends Remote{
	
	public void updateMe (int x,int y,Map<String,Integer> scores) throws RemoteException;
	public String getPlayerName() throws RemoteException;
}
