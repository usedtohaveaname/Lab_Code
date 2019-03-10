import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    private static ServerAction stub = null;
    public RMIClient(){}
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            stub = (ServerAction) reg.lookup("noobServer");
            System.out.println("Welcome");
            System.out.println("1. Login 2. Register");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            switch (x)
            {
                case 1:
                    String username = "";
                    String password = "";
                    System.out.print("Username: ");
                    username = scanner.next();
                    System.out.print("Password: ");
                    password = scanner.next();
                    System.out.println("Authenticating...");
                    if(stub.login(username, password)) {
                        System.out.println("Login success!");
                    } else {
                        System.out.println("Login fail! Please check your credentials");
                    }
                    break;
                case 2:
                    register();

            }

            stub.register();
        } catch (Exception e) {
            System.out.print("Client exception thrown: "+e.toString());
        }

    }
    private static void register(){
        Scanner scanner = new Scanner(System.in);
        Dao dao = new Dao();
        String username = "";
        String password = "";
        System.out.print("Username: ");
        username = scanner.next();
        System.out.print("Password: ");
        password = scanner.next();
        dao.register_user(username, password);
    }
}
