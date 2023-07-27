package Homework.H21WebCode;

import java.io.IOException;
import java.net.*;

public class H02_B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = "四大名著是那些？".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.201.150.248"), 9998);

        socket.send(packet);

        byte[] bytes2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(bytes2,bytes2.length);
        socket.receive(packet2);
        String str = new String(packet2.getData(), 0, packet2.getLength());
        System.out.println(str);

        socket.close();


    }
}
