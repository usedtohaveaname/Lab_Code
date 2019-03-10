import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ServerAction extends Remote{
    public boolean login() throws RemoteException;
    
}