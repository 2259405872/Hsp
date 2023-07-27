package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCP03_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream ops = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ops));
        System.out.println("客户端连接成功，ops.class="+ops.getClass().getName());

        bw.write("Hello server");
        bw.flush();
        socket.shutdownOutput();//输出结束标记

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();
        System.out.println(str);
        socket.shutdownInput();//输入结束标记

        br.close();
        bw.close();
        socket.close();
    }
}
