package datagramConnect;

import devices.Device;
import devices.SmartLight;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Date;

public class DatagramConnector{
    private Device attachedDevice;
    private Thread ping;
    private int port;
    private byte[] deviceBuf = new byte[256];


    public DatagramConnector(Device attachedDevice) {

        this.attachedDevice = attachedDevice;

    }

    public DatagramConnector()
    {

    }

    public Device getAttachedDevice() {
        return attachedDevice;
    }

    public void sendDevice(String device) {
        try {

            DatagramSocket socket = new DatagramSocket();
            //InetAddress localAddress = InetAddress.getLocalHost();
            InetAddress targetAddress = InetAddress.getByName("localhost");
            int localPort = socket.getLocalPort();
            setPort(localPort);
            socket.setSoTimeout(30000);
            int pingReminder = 0;
            int exitCounter = 0;
            while (true) {


                deviceBuf = device.getBytes();
                DatagramPacket packet = new DatagramPacket(deviceBuf, deviceBuf.length , targetAddress, 41234);
                socket.send(packet);
                byte[] buffer = new byte[512];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(response);
                } catch (SocketTimeoutException ste) {
                    System.out.println("Timeout awaiting response...");
                }

                Thread.sleep(1500);
                if (!socket.isConnected()) {
                    pingReminder++;
                    exitCounter++;
                    if (exitCounter == 40) {
                        System.out.println("Ping thread dying");
                       // System.out.println("Dying Device: " + this.getAttachedDevice().getDeviceName());
                        this.ping.join();
                    }
                    if (pingReminder == 10) {
                        pingReminder = 0;
                        //System.out.println("REMINDER OF DEVICE-NAME: " + this.getAttachedDevice().getDeviceName());
                        //System.out.println("Host address: " + request.getAddress().getHostAddress());
                        //System.out.println("Port number: " + request.getPort());
                    }
                }
            }

        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public int getPort()
    {
        return port;
    }

}


