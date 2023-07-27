package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP04_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        File file = new File("out/production/Hsp/bomb03.png");
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
        byte[] array=getByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(array);
        bos.flush();
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        br.close();
        bos.close();
        bis.close();
        socket.close();

    }

    public static byte[] getByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.flush();
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }
}
