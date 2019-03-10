import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginImpl extends UnicastRemoteObject implements ServerAction {
    public LoginImpl() throws RemoteException{
        super();
    };
    public boolean login () throws RemoteException{
        System.out.println("login success!");
        return true;
    }
}