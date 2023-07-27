package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP01_B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        int len =packet.getLength();
        String str = new String(bytes, 0, len);
        System.out.println(str);

        byte[] bytes01 = "吃呀，可以呀".getBytes();
        DatagramPacket packet01 = new DatagramPacket(bytes01,bytes01.length, InetAddress.getByName("10.201.150.248"),9998);
        socket.send(packet01);

        socket.close();
        System.out.println("B退出");
    }
}
