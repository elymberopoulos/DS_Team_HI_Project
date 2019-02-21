package main;

//import com.google.*;
//import com.google.gson.Gson;
import datagramConnect.DatagramConnector;
import deviceManager.DeviceManager;
import devices.Device;
import uiText.UserInterfaceHelper;
import uiText.UserInterfaceText;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {



        Device device = new Device();
        DatagramConnector dc = new DatagramConnector();
        ThreadGroup threadGroup = new ThreadGroup("timers");
        DeviceManager deviceManager = new DeviceManager();
        Map lights = deviceManager.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = deviceManager.getDeviceMap().put("power strips", new TreeMap<>());
        UserInterfaceText uiInvoker = new UserInterfaceText(deviceManager);
        UserInterfaceHelper ui = new UserInterfaceHelper();
        ////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Please enter a command");
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Type 'help' if needed.");
            String commandInput = scanner.nextLine().toLowerCase();

            switch (commandInput) {

                case "add device":
                    uiInvoker.addDevice();
                    break;
                case "remove device":
                    uiInvoker.removeDevice();
                    break;
                case "manage device":

                    System.out.println("Available options:\n" +
                            "set light power, set power strip power");
                    String manageInput = scanner.nextLine().toLowerCase();
                    if (manageInput.equalsIgnoreCase("set light power")) {
                        uiInvoker.manageSmartLight();
                    }
                    ////////////////////////////POWER STRIP SECTION/////////////////////////////////////////
                    if (manageInput.equalsIgnoreCase("set power strip power")) {
                        uiInvoker.managePowerStrip();
                    }

                    break;
                case "move device":
                    uiInvoker.moveDevice();
                    break;
                case "set timer":
                    uiInvoker.setTimer();
                    break;

                case "set schedule":
                    uiInvoker.setSchedule();
                    break;
                case "show devices":
                    deviceManager.showDevices();
                    break;
                case "show device":
                    deviceManager.showDevices();
                    break;
                case "show devices with state":
                    deviceManager.showDevicesWithState();
                    break;
                case "cls":
                    ui.cls();
                    break;
                case "help":
                    ui.help();
                    break;
                case "exit":
                    System.exit(0);

                default:
                    System.out.println("\n\n<<<<<<<    Invalid command try again.    >>>>>>>>>" +
                            "\n---------------------------------------------------\n\n");
            }

        } while (true);

    }
}