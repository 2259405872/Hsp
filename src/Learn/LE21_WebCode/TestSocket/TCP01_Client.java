package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCP01_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream ops = socket.getOutputStream();
        System.out.println("客户端连接成功，ops.class="+ ops.getClass().getName());
        ops.write("Hello world".getBytes());
        ops.close();
        socket.close();
    }
}
