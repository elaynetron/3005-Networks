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
public class Rfc865UdpServer {
    public static void main(String[] argv) {
    //
    // 1. Open UDP socket at well-known port
    //
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
        }
        while (true) {
            try {
                //
                // 2. Listen for UDP request from client
                //
                byte[] requestBuffer = new byte[512];
                DatagramPacket request = new DatagramPacket(requestBuffer, 
                        requestBuffer.length);
                socket.receive(request);
                
                String temp = new String(requestBuffer);
                System.out.println(temp);
                
                InetAddress IPAddress = request.getAddress();
                int port = request.getPort();
                
                //
                // 3. Send UDP reply to client
                //
                byte[] replyBuffer = new byte[512];
                DatagramPacket reply = new DatagramPacket(replyBuffer, 
                        replyBuffer.length, IPAddress, port);
                socket.send(reply);
            } catch (IOException e) {
            }
        }
    }
}
