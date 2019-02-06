package devices;
import timer.Timer;
import java.util.Date;
import java.util.Scanner;

public class Device implements IDevice {
    private String deviceName;
    private boolean powerSwitch;
    private Timer timer;

    public Device(){
        this.deviceName = null;
        this.powerSwitch = false;
        this.timer = new Timer(0 , this);
    }
    public Timer getTimer(){
        return timer;
    }

    public boolean checkTimer(){
        if(this.getTimer().isRunning()){
            return true;
        }
        return false;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPowerSwitch() {
        if(this.powerSwitch == true){
            this.powerSwitch = false;
        }
        else{
            this.powerSwitch = true;
        }
    }

    public boolean isDeviceOn() {
        return powerSwitch;
    }

}
