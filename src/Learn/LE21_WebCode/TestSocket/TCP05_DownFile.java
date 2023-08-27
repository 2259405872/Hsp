package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP05_DownFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动成功...");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功...");

        BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
        File file = new File("src/Learn/LE21_WebCode/bomb03.png");
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bytes = new byte[1024];
        int len =-1;
        System.out.println("正在接受文件...");
        while ((len = bi.read(bytes))!=-1){
            bo.write(bytes, 0, len);
        }
        bo.flush();
        bo.close();
        System.out.println("文件传输完毕...");

        socket.shutdownInput();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("文件已接收...");

        bw.close();
        bi.close();
        socket.close();
        System.out.println("客户端连接已断开...");
        serverSocket.close();
        System.out.println("服务已关闭...");
    }
}
