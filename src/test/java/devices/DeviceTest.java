package devices;

import deviceManager.DeviceManager;
//import org.junit.jupiter.api.Test;
import timer.Timer;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.*;

public class DeviceTest {

    @Test
  public  void setPowerSwitch() {
        Device d = new Device();
        assertFalse(d.isDeviceOn());
        d.setPowerSwitch();
        assertTrue(d.isDeviceOn());
    }

    @Test
    public  void isDeviceOn() {
        Device device = new Device();
        boolean result = device.isDeviceOn();
        assertFalse(result);
        device.setPowerSwitch();
        assertTrue(device.isDeviceOn());
    }

    @Test
    public  void getTimer() {
        Device d = new Device();
        Timer timer = d.getTimer();
        assertEquals(timer, d.getTimer());
    }

    @Test
    public  void checkTimer() { // checks if timer is running
        Device d = new Device();
        Timer timer = d.getTimer();
        timer.setTime(1);
        Thread thread = new Thread(timer);

        assertFalse(d.getTimer().isRunning());
        thread.start();
        Thread delay = new Thread();

        try { // delay so that run method has time to change timer boolean value of running
            delay.run();
            delay.sleep(100);
            delay.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(d.getTimer().isRunning());
        try { // delay so that run method has time to change timer boolean value of running
            delay.run();
            delay.sleep(1500);
            delay.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(d.getTimer().isRunning());
    }

    @Test
    public  void getDeviceName() {
        SmartLight l = null;
        try {
            l = new SmartLight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeviceManager dm = new DeviceManager();
        Map lights = dm.getDeviceMap().put("lights", new TreeMap<>());
        Map powerStrips = dm.getDeviceMap().put("power strips", new TreeMap<>());
        dm.addDevice("name", l, "lights");
        assertNotEquals("nam", l.getDeviceName());
        assertEquals("name", l.getDeviceName());
    }

    @Test
    public   void setDeviceName() {
        SmartLight l = null;
        try {
            l = new SmartLight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotEquals("name", l.getDeviceName());
        l.setDeviceName("name");
        assertEquals("name", l.getDeviceName());
    }

    @Test
    public   void showState() { //already tested with is on, tested running thread
    }
}