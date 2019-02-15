package deviceManager;

import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;

import java.util.Map;
import java.util.TreeMap;


public class DeviceManager implements IDeviceManager {
    private TreeMap<String, TreeMap<String, Device>> deviceMap;


    public DeviceManager() {
        //this.deviceMap = new TreeMap<String, Map<String, Map<String, Device>>>();
        this.deviceMap = new TreeMap<String, TreeMap<String, Device>>();
    }

    public SmartLight generateSmartBulb() {
        return new SmartLight();
    }

    public SmartPowerStrip generateSmartPowerStrip() {
        return new SmartPowerStrip();
    }

    public TreeMap<String, TreeMap<String, Device>> getDeviceMap() {
        return deviceMap;
    }

    public void showDevices() {
        System.out.println("\t\t\t\t<<<<<<<< CURRENT DEVICES >>>>>>>>>");
        System.out.println("______________________________________________________________________");
        for (String key : this.getDeviceMap().keySet()) {
            System.out.println("COLLECTION: " + "'" + key + "'" + ": " + this.getDeviceMap().get(key));
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void showDevicesWithState(){
        int formatCounter = 0;
        for(Map.Entry<String, TreeMap<String, Device>> key: this.getDeviceMap().entrySet()){
            System.out.print("\nCOLLECTION: '" + key.getKey() + "'\n");
            for (Map.Entry<String, Device> collectionKey: key.getValue().entrySet()) {
                System.out.print(" <><> Key: '" + collectionKey.getKey() + "' Device Power State: " + collectionKey.getValue().isDeviceOn());
                if (collectionKey.getValue() instanceof SmartLight){
                    System.out.print("Smart Light Brightness level: " + ((SmartLight) collectionKey.getValue()).getBrightness());
                }
                if (collectionKey.getValue() instanceof SmartPowerStrip){
                    System.out.print(" Power Strip");
                }
                formatCounter++;
                if(formatCounter == 2){
                    System.out.print("\n");
                    formatCounter = 0;
                }
            }
        }
        System.out.print("\n");
    }

    public void addDevice(String newKey, Device device, String targetCollection) {
        for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && !entry.getValue().containsKey(newKey)) {
                device.setDeviceName(newKey);
                Device obj = entry.getValue().put(newKey, device);
                portDevices(obj);
            }
        }
    }

    public void removeDevice(String removeKey, String targetCollection) {
        for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(removeKey)) {
                entry.getValue().remove(removeKey);
            }
        }
    }

    public String getDeviceName(String key, String targetCollection) {
        for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(key)) {
                return entry.getValue().get(key).getDeviceName();
            }
        }
        System.out.println("The device was not found.");
        return null;
    }

    public void setDeviceName(String key, String newName, String targetCollection) {
        for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(key)) {
                entry.getValue().get(key).setDeviceName(newName);
                System.out.println("The device name was changed to: " + newName);
            }
        }
    }


    public Device getDevice(String key, String targetCollection) {
            for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
                if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(key)) {
                    return entry.getValue().get(key);
                }
            }
        return null;
    }

    public void moveDevice(String moveKey, String targetCollection, String destinationCollection) {
        Device placeHolder;
        for (Map.Entry<String, TreeMap<String, Device>> entry : this.getDeviceMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase(targetCollection) && entry.getValue().containsKey(moveKey)) {
                placeHolder = entry.getValue().remove(moveKey);
                this.addDevice(moveKey, placeHolder, destinationCollection);
            }
        }
    }

    public void portDevices(Device device)
    {
        Gson gson = new Gson();
        String json = Gson.toJson(device);
        //entrypoint here
    }
}
