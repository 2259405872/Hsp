package Homework.H21WebCode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class H02_A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        byte[] bytes2 = "四大名著里面包括了四大名著".getBytes();
        DatagramPacket packet2 = new DatagramPacket(bytes2, bytes2.length, InetAddress.getByName("10.201.150.248"), 9999);
        socket.send(packet2);

        socket.close();
    }
}
