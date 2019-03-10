import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ServerAction extends Remote{
    public boolean login(String username, String password) throws RemoteException;
    public boolean register() throws RemoteException;
    
}