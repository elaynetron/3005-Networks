/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RFC865;
import java.io.IOException;
import java.net.*;
/**
 *
 * @author etan074
 */
public class Rfc865UdpClient {
    public static void main(String[] argv) throws UnknownHostException {
    //
    // 1. Open UDP socket
    //
    DatagramSocket socket = null;
    InetAddress IPAddress = InetAddress.getByName("HWLab1");
    try {
        socket = new DatagramSocket();
        socket.connect(IPAddress, 17);
    } catch (SocketException e) {}

    try {
        //
        // 2. Send UDP request to server
        //
        
        byte[] requestBuffer = "Elayne Tan, TE1, 172.21.145.123".getBytes("UTF-8");
        DatagramPacket request = new DatagramPacket(requestBuffer, 
                        requestBuffer.length);
        socket.send(request);
        
        //
        // 3. Receive UDP reply from server
        //
        byte[] replyBuffer = new byte[512];
        DatagramPacket reply = new DatagramPacket(replyBuffer, 
                        replyBuffer.length);
        socket.receive(reply);
        
        String temp = new String(replyBuffer);
        System.out.println(temp);
        
    } catch (IOException e) {}
    finally{
        socket.close();
    }
 }
}

/* 
 * Wise men talk because they have something to say; 
 * fools, because they have to say something - Plato.
 */
