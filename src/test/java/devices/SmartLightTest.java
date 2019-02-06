package devices;


import org.junit.Test;

import static org.junit.Assert.*;

public class SmartLightTest {

    @Test
    public   void setBrightness() {
        SmartLight sl = new SmartLight();
        assertNotEquals(1, sl.getBrightness());
        sl.setBrightness(2);
        assertEquals(2, sl.getBrightness());
    }

    @Test
    public  void getBrightness() {
        SmartLight sl = new SmartLight();
        assertEquals(0, sl.getBrightness());
        assertNotEquals(2, sl.getBrightness());
        sl.setBrightness(3);
        assertEquals(3, sl.getBrightness());
    }

    @Test
    public   void setPowerSwitch() {
        SmartLight sl = new SmartLight();
        assertFalse(sl.isDeviceOn());
        sl.setPowerSwitch();
        assertTrue(sl.isDeviceOn());
    }
}