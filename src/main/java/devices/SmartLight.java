package devices;

public class SmartLight extends Device implements ISmartLight {

    private int brightness;

    public SmartLight() {
        this.brightness = 0;
    }

    @Override
    public void setBrightness(int value) {
        if(value < 0 || value > 10){
            System.out.println("Invalid brightness level.");
        }
        else{
            this.brightness = value;
        }
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    public void setPowerSwitch(){
        super.setPowerSwitch();
        if(!super.isDeviceOn()){
            this.brightness = 0;
        }
    }
}
