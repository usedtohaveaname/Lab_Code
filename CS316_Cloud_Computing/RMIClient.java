import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RMIClient {
    private static serverAction stub = null;
    public RMIClient(){}
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            stub = (Login) reg.lookup("noobServer");
            stub.login();
        } catch (Exception e) {
            System.out.print("Client exception thrown: "+e.toString());
        }
        
    }
}
