package deviceManager;

public class UserInterfaceHelper {
    public UserInterfaceHelper(){}

    public void cls(){
        for(int i = 0; i<30; i++){
            System.out.println("\n");
        }
    }

    public void help(){
        System.out.println("\t\t\t << This is the help menu >>");
        System.out.println("VALID COMMANDS:\n" +
                "\tadd device, remove device, move device, manage device\n" +
                "\tset timer, set schedule, show devices, show devices with state, cls, help, exit\n" +
                "____________________________________________________________");
    }
}
