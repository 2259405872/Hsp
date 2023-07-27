package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP03_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("服务端连接成功,inputStream.class=" + inputStream.getClass().getName());

        String str = br.readLine();
        System.out.println(str);
        socket.shutdownInput();//输入结束标记

        OutputStream ops = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ops));
        bw.write("hello client");
        bw.flush();
        socket.shutdownOutput();//输出结束标记

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
