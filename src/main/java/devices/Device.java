package devices;

import datagramConnect.DatagramConnector;
import timer.Timer;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Device implements IDevice {
    private String deviceName;
    private boolean powerSwitch;
    private Timer timer;
    private DatagramConnector datagramConnector;
    private Thread ping;

    public Device() {
        this.deviceName = null;
        this.powerSwitch = false;
        this.timer = new Timer(0, this);
        this.datagramConnector = new DatagramConnector(this);
    }

    public DatagramConnector getDatagramConnector() {
        return datagramConnector;
    }

    public Timer getTimer() {
        return timer;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean isDeviceOn() {
        return powerSwitch;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public boolean checkTimer() {
        if (this.getTimer().isRunning()) {
            return true;
        }
        return false;
    }

    public void setPowerSwitch() {
        if (this.powerSwitch == true) {
            this.powerSwitch = false;
        } else {
            this.powerSwitch = true;
        }
    }

}

