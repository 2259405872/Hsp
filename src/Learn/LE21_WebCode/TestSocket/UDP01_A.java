package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.net.*;

public class UDP01_A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        byte[] bytes = "明天去吃火锅吗".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("10.201.150.248"),9999);
        socket.send(packet);

        byte[] bytes01 = new byte[1024];
        DatagramPacket packet01 = new DatagramPacket(bytes01, bytes01.length);
        socket.receive(packet01);

        int len =packet01.getLength();
        String str = new String(bytes01, 0, len);
        System.out.println(str);

        socket.close();
        System.out.println("A退出");
    }
}
