package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP02_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        System.out.println("服务端连接成功,inputStream.class=" + inputStream.getClass().getName());

        byte[] bytes = new byte[1024];
        int len=0;
        while ((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes, 0, len));
        }
        socket.shutdownInput();//输入结束标记

        OutputStream ops = socket.getOutputStream();
        ops.write("hello client".getBytes());
        socket.shutdownOutput();//输出结束标记

        ops.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
