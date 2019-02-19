package datagramConnect;

import devices.Device;
import devices.SmartLight;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Date;

/*public class DatagramConnector implements Runnable {
    private Device attachedDevice;
    private Thread ping;
    private int port;


    public DatagramConnector(Device attachedDevice) {
        this.attachedDevice = attachedDevice;
        this.ping = new Thread(this);
        ping.start();
    }

    public DatagramConnector()
    {

    }


    public Thread getPing() {
        return ping;
    }


    public Device getAttachedDevice() {
        return attachedDevice;
    }

    public void run() {
        try {

            DatagramSocket socket = new DatagramSocket();
            InetAddress localAddress = InetAddress.getLocalHost();
            int localPort = socket.getLocalPort();
            setPort(localPort);
            socket.setSoTimeout(30000);
            int pingReminder = 0;
            int exitCounter = 0;
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[1], 1, localAddress, 4444);

                socket.send(request);

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
                        System.out.println("Dying Device: " + this.getAttachedDevice().getDeviceName());
                        this.ping.join();
                    }
                    if (pingReminder == 10) {
                        pingReminder = 0;
                        System.out.println("REMINDER OF DEVICE-NAME: " + this.getAttachedDevice().getDeviceName());
                        System.out.println("Host address: " + request.getAddress().getHostAddress());
                        System.out.println("Port number: " + request.getPort());
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

}*/

public class DatagramConnector {
    private DatagramSocket clientSocket;
    private InetAddress address;
    private Device attachedDevice;
    public static int port;
    private boolean isConnected;
    private DatagramPacket packet;
    private byte[] buf = new byte[1024];

    public DatagramConnector() throws IOException {
        clientSocket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        isConnected = clientSocket.isConnected();
        this.attachedDevice = attachedDevice;


    }

    public void sendEcho(String test) throws IOException {

        buf = test.getBytes();
        packet = new DatagramPacket(buf, buf.length, address, 41234);
        clientSocket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        //clientSocket.close();
        //clientSocket.receive(packet);
        //String received = new String(packet.getData(), 0, packet.getLength());
        //return received;
    }

    public void close() {
        clientSocket.close();
    }


}


