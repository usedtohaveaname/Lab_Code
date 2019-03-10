import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
public class RMIServer {
    public RMIServer(){}
    public static void main(String[] args) {
        try {
	        LocateRegistry.createRegistry(1099);
            ServerAction server = new LoginImpl();
            Naming.rebind("noobServer",server);
            System.out.println("noob server is up and running");
        } catch ( Exception e) {
            System.out.println("Server throws exception: " + e.toString() );
        }
    }
    
    
}
