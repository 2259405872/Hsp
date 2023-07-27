package Learn.LE21_WebCode.TestSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP01_Server {
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

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
