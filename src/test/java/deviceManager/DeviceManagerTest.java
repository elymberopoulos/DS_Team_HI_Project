package deviceManager;

import devices.Device;
import devices.SmartLight;
import devices.SmartPowerStrip;
//import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceManagerTest {


    @Test
    public  void addDevice() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        System.out.println(testResult);
        assertNotNull(testResult);
    }

    @Test
    public  void removeDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        assertNotNull(testResult);

        dm.removeDevice("testKey", "Lights");
        assertTrue(!dm.getDeviceMap().get("lights").containsKey("testKey"));
    }

    @Test
    public  void moveDevice() {
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        Device d = new Device();

        dm.addDevice("testKey", d, "lights");
        Device testResult = dm.getDeviceMap().get("lights").get("testKey");
        assertNotNull(testResult);

        dm.moveDevice("testKey", "lights", "power strips");
        assertFalse(dm.getDeviceMap().get("lights").containsKey("testKey"));
        assertTrue(dm.getDeviceMap().get("power strips").containsKey("testKey"));
    }

    @Test
    public  void generateSmartBulb() {
        DeviceManager d = new DeviceManager();
        SmartLight light = null;
        try {
            light = d.generateSmartBulb();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(light);
        assertTrue(light instanceof SmartLight);
    }

    @Test
    public  void generateSmartPowerStrip() {
        DeviceManager d = new DeviceManager();
        SmartPowerStrip powerStrip = null;
        try {
            powerStrip = d.generateSmartPowerStrip();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(powerStrip);
        assertTrue(powerStrip instanceof SmartPowerStrip);
    }

    @Test
    public  void getDeviceMap() {
        DeviceManager d = new DeviceManager();
        Map t = d.getDeviceMap();
        assertNotNull(t);
        assertTrue(t instanceof TreeMap);
    }

    @Test
    public  void getDeviceName() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = null;
        try {
            smartLight = new SmartLight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SmartPowerStrip powerStrip = null;
        try {
            powerStrip = new SmartPowerStrip();
        } catch (IOException e) {
            e.printStackTrace();
        }


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        Device lightResult = dm.getDeviceMap().get("lights").get("light");
        Device powerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertNotNull(lightResult);
        assertNotNull(powerStripResult);
        assertEquals("light", lightResult.getDeviceName());
        assertEquals("power", powerStripResult.getDeviceName());
    }

    @Test
    public   void setDeviceName() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = null;
        try {
            smartLight = new SmartLight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SmartPowerStrip powerStrip = null;
        try {
            powerStrip = new SmartPowerStrip();
        } catch (IOException e) {
            e.printStackTrace();
        }


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        Device lightResult = dm.getDeviceMap().get("lights").get("light");
        Device powerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertNotNull(lightResult);
        assertNotNull(powerStripResult);
        assertEquals("light", lightResult.getDeviceName());
        assertEquals("power", powerStripResult.getDeviceName());
        dm.setDeviceName("light", "newName", "lights");
        dm.setDeviceName("power", "newerName", "power strips");
        Device newLightResult = dm.getDeviceMap().get("lights").get("light");
        Device newPowerStripResult = dm.getDeviceMap().get("power strips").get("power");
        assertEquals("newName", newLightResult.getDeviceName());
        assertEquals("newerName", newPowerStripResult.getDeviceName());
    }

    @Test
    public   void getDevice() {
        DeviceManager dm = new DeviceManager();

        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        SmartLight smartLight = null;
        try {
            smartLight = new SmartLight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SmartPowerStrip powerStrip = null;
        try {
            powerStrip = new SmartPowerStrip();
        } catch (IOException e) {
            e.printStackTrace();
        }


        dm.addDevice("light", smartLight, "lights");
        dm.addDevice("power", powerStrip, "power strips");
        assertEquals(smartLight, dm.getDevice("light", "lights"));
        assertEquals(powerStrip, dm.getDevice("power", "power strips"));
    }

}