package timer;

import devices.Device;

public interface ITimer extends Runnable{
    public long getSchedule();
    public void setSchedule(long waitTime);
    public boolean isRunning();
    public int getTime();
    public Device getAttachedDevice();
    public void setTime(int time);
}
