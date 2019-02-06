package main;

import deviceManager.DeviceManager;
import deviceManager.UserInterfaceHelper;
import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;
import timer.Timer;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        ThreadGroup threadGroup = new ThreadGroup("timers");
        DeviceManager deviceManager = new DeviceManager();
        Map lights = deviceManager.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = deviceManager.getDeviceMap().put("power strips", new TreeMap<>());
        UserInterfaceHelper ui = new UserInterfaceHelper();
        ////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Please enter a command");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Type 'help' if needed.");
            String commandInput = scanner.nextLine().toLowerCase();

            switch (commandInput) {

                case "add device":
                    try {
                        deviceManager.showDevices();
                        System.out.println("What type of device?\n\t < 'smart light' >\n\t < 'smart power strip' >");
                        String input = scanner.nextLine().toLowerCase();
                        if (input.contentEquals("smart light")) {
                            SmartLight newLight = deviceManager.generateSmartBulb();
                            System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                    "\tDEVICE KEY: ");
                            String deviceKey = scanner.nextLine().toLowerCase();
                            System.out.print("\tDEVICE COLLECTION NAME: ");
                            String deviceCollection = scanner.nextLine().toLowerCase();
                            deviceManager.addDevice(deviceKey, newLight, deviceCollection);
                        } else if (input.contentEquals("smart power strip")) {
                            SmartPowerStrip newPower = deviceManager.generateSmartPowerStrip();
                            System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                    "\tDEVICE KEY: ");
                            String deviceKey = scanner.nextLine().toLowerCase();
                            System.out.print("\tDEVICE COLLECTION NAME: ");
                            String deviceCollection = scanner.nextLine().toLowerCase();
                            deviceManager.addDevice(deviceKey, newPower, deviceCollection);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e);
                    }
                    break;
                case "remove device":
                    try {
                        System.out.print("\tEnter key of device to remove:");
                        String removeKey = scanner.nextLine().toLowerCase();
                        System.out.print("\tEnter name of the device's collection:");
                        String collection = scanner.nextLine().toLowerCase();
                        deviceManager.removeDevice(removeKey, collection);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e);
                    }

                    break;
                case "manage device":
                    try {
                        System.out.println("Available options:\n" +
                                "set light power, set power strip power");
                        String manageInput = scanner.nextLine().toLowerCase();
                        if (manageInput.equalsIgnoreCase("set light power")) {
                            System.out.print("Enter device key:");
                            String manageKey = scanner.nextLine().toLowerCase();
                            System.out.print("Enter device collection:");
                            String manageCollection = scanner.nextLine().toLowerCase();
                            Device manageDevice = (SmartLight) deviceManager.getDevice(manageKey, manageCollection);
                            if (manageDevice.getClass() != SmartLight.class) {
                                System.out.println("Invalid device type");
                                break;
                            }
                            System.out.println("The devices power is currently " + manageDevice.isDeviceOn() + " with a brightness of " + ((SmartLight) manageDevice).getBrightness() + " switch power? [y/n]:");
                            if (scanner.nextLine().equalsIgnoreCase("y")) {
                                manageDevice.setPowerSwitch();
                                System.out.println("The devices power is now " + manageDevice.isDeviceOn() + ".");
                            }
                            System.out.println("Device power must be true to adjust brightness.");
                            System.out.println("Would you like to adjust the brightness? [y/n]");
                            if (scanner.nextLine().equalsIgnoreCase("y") && ((SmartLight) manageDevice).isDeviceOn()) {
                                System.out.print("Select a value from 0 - 10:");
                                int brightness = Integer.parseInt(scanner.nextLine().toLowerCase());
                                ((SmartLight) manageDevice).setBrightness(brightness);
                                System.out.println("The devices brightness is now " + ((SmartLight) manageDevice).getBrightness() + ".");
                            }
                        }
                        ////////////////////////////POWER STRIP SECTION/////////////////////////////////////////
                        if (manageInput.equalsIgnoreCase("set power strip power")) {
                            System.out.print("Enter device key:");
                            String manageKey = scanner.nextLine().toLowerCase();
                            System.out.print("Enter device collection:");
                            String manageCollection = scanner.nextLine().toLowerCase();
                            Device manageDevice = (SmartPowerStrip) deviceManager.getDevice(manageKey, manageCollection);
                            if (manageDevice.getClass() != SmartPowerStrip.class) {
                                System.out.println("Invalid device type");
                                break;
                            }
                            System.out.println("The devices power is currently " + manageDevice.isDeviceOn() + " switch power? [y/n]:");
                            if (scanner.nextLine().equalsIgnoreCase("y")) {
                                manageDevice.setPowerSwitch();
                                System.out.println("The devices power is now " + manageDevice.isDeviceOn() + ".");
                            }

                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e);
                    }

                    break;
                case "move device":
                    try {
                        deviceManager.showDevices();
                        System.out.println("This option allows for the moving of a device from its original collection to a new collection.");
                        System.out.print("What is the original collection name:");
                        String originalCollection = scanner.nextLine().toLowerCase();
                        System.out.print("What is the key name of the device to be moved:");
                        String key = scanner.nextLine().toLowerCase();
                        System.out.print("Enter destination collection name:");
                        String destinationCollection = scanner.nextLine().toLowerCase();
                        deviceManager.moveDevice(key, originalCollection, destinationCollection);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e);
                    }
                    break;
                case "set timer":
                    try {
                        System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                "\tDEVICE KEY: ");
                        String deviceKey = scanner.nextLine().toLowerCase();
                        System.out.print("\tDEVICE COLLECTION NAME: ");
                        String deviceCollection = scanner.nextLine().toLowerCase();
                        Device targetDevice = deviceManager.getDevice(deviceKey, deviceCollection);
                        Timer targetTimer = targetDevice.getTimer();
                        System.out.println("Please enter a timer time in seconds.");
                        int timeInput = Integer.parseInt(scanner.nextLine());
                        targetTimer.setTime(timeInput);
                        Thread thread = new Thread(targetTimer);
                        thread.start();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e);
                    }
                    break;

                case "set schedule":
                    try {
                        System.out.print("<<<<<\t ENTER DEVICE INFORMATION\t>>>>>>\n" +
                                "\tDEVICE KEY: ");
                        String deviceKey = scanner.nextLine().toLowerCase();
                        System.out.print("\tDEVICE COLLECTION NAME: ");
                        String deviceCollection = scanner.nextLine().toLowerCase();
                        Device targetDevice = deviceManager.getDevice(deviceKey, deviceCollection);
                        Timer targetTimer = targetDevice.getTimer();
                        System.out.println("Please enter a timer time in seconds.");
                        int timeInput = Integer.parseInt(scanner.nextLine());
                        targetTimer.setTime(timeInput);
                        System.out.println("Next input options are for a setting a schedule.");
                        System.out.print("Start in how many HOURS: ");
                        int hours = (Integer.parseInt(scanner.nextLine()));
                        System.out.print("Start in how many MINUTES: ");
                        int minutes = (Integer.parseInt(scanner.nextLine()));
                        long startProduct = ((hours * 3600000) + (minutes * 60000));
                        targetTimer.setSchedule(startProduct);
                        Thread scheduleThread = new Thread(targetTimer);
                        scheduleThread.start();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ERROR >> INVALID ENTRIES: " + e.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR: " + e.toString());
                    }
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