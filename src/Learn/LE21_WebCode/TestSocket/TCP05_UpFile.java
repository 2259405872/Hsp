package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP05_UpFile {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("成功连接服务器...");

        BufferedOutputStream bo = new BufferedOutputStream(socket.getOutputStream());
        File file = new File("out/production/Hsp/bomb03.png");
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes= new byte[1024];
        System.out.println("文件上传中...");

        int len =-1;
        while ((len = bi.read(bytes))!=-1) {
            bo.write(bytes,0,len);
        }
        bo.flush();
        System.out.println("文件上传成功");

        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("收到来自服务器的消息:'"+s+"'");

        bi.close();
        bo.close();
        br.close();
        socket.close();
        System.out.println("服务器连接已断开...");



    }
}
