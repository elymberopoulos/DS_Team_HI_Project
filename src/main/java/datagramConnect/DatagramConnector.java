package datagramConnect;

import devices.Device;
import devices.SmartLight;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Date;


public class DatagramConnector implements Serializable {
    private DatagramSocket clientSocket;
    private InetAddress address;
    private Device attachedDevice;
    public static int port;
    private boolean isConnected;
    private DatagramPacket packet;
    private byte[] buf = new byte[1024];
    private byte[] objByte = new byte[1024];

    public DatagramConnector(Device attachedDevice) throws IOException {
        clientSocket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        isConnected = clientSocket.isConnected();
        this.attachedDevice = attachedDevice;
//        this.sendEcho("Device name: " + attachedDevice.getDeviceName() + " " + attachedDevice.toString());
        this.sendEcho(this.objToByte(attachedDevice));


    }

    private byte[] objToByte(Device device)  {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(device);
            out.flush();
            objByte = bos.toByteArray();
            return objByte;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return null;
    }

    public void sendEcho(byte[] test) throws IOException {

        buf = test;
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


