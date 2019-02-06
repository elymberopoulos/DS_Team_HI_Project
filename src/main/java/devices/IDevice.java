package devices;

import timer.Timer;

public interface IDevice {
    public boolean isDeviceOn();
    public Timer getTimer();
    public void setPowerSwitch();
    public void setDeviceName(String deviceName);
}
