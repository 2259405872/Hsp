package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCP02_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream ops = socket.getOutputStream();
        System.out.println("客户端连接成功，ops.class="+ops.getClass().getName());
        ops.write("Hello server".getBytes());
        socket.shutdownOutput();//输出结束标记

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len=0;
        while ((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes, 0, len));
        }
        socket.shutdownInput();//输入结束标记

        inputStream.close();
        ops.close();
        socket.close();
    }
}
