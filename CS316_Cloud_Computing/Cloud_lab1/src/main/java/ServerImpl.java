package main.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerAction {
    public ServerImpl() throws RemoteException{
        super();
    };
    public boolean login (String username, String password) throws RemoteException{
        Dao dao = new Dao();
        return dao.login_authenticate(username, password);
    }
    public boolean register(String username, String password) throws RemoteException{
        Dao dao = new Dao();

        return dao.register_user(username, password);
    }
}