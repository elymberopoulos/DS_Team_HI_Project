//package ServerTest;
//
//import DataGramServer.DatagramServer;
//import datagramConnect.DatagramConnector;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.*;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//
//public class UDPConnectionTest {
//
//
//    DatagramConnector client;
//
//    @Before
//    public void setup() throws IOException{
//        new DatagramServer().start();
//        client = new DatagramConnector();
//
//    }
//
//    @Test
//    public void whenCanSendAndReceivePacket_thenCorrect() throws IOException {
//
//
//        assertEquals(false,client.isConnected());
//       /* String echo = client.sendEcho("hello server");
//        assertEquals("hello server", echo);
//        echo = client.sendEcho("server is working");
//        assertFalse(echo.equals("hello server"));*/
//    }
//
//
//
//    @After
//    public void tearDown() throws IOException {
//        client.sendEcho("end");
//        client.close();
//    }
//}
