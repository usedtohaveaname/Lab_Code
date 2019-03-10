import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerAction {
    public ServerImpl() throws RemoteException{
        super();
    };
    public boolean login (String username, String password) throws RemoteException{
        Dao dao = new Dao();
        dao.login_authenticate(username, password);
        return true;
    }
    public boolean register() throws RemoteException{
        System.out.println("register success!");
        return true;
    }
}