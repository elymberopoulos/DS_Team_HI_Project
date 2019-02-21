package devices;

import datagramConnect.DatagramConnector;
import timer.Timer;

import java.io.IOException;

public class SmartPowerStrip extends Device {
    public SmartPowerStrip() throws IOException {
        DatagramConnector datagramConnector = new DatagramConnector(this);

    }

}


