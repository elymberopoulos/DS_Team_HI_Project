package deviceManager;

import devices.Device;

import java.io.IOException;
import java.util.TreeMap;

public interface IDeviceManager {
    public TreeMap<String, TreeMap<String, Device>> getDeviceMap();
    public void showDevices();
    public void addDevice(String newKey, Device device, String targetCollection);
    public void removeDevice(String removeKey, String targetCollection);
    public void moveDevice(String moveKey, String targetCollection, String destinationCollection);
}
