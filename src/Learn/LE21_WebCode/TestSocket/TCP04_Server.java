package Learn.LE21_WebCode.TestSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP04_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] array = getByteArray(bis);

        File file = new File("src/Learn/LE21_WebCode/boom.png");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(array);
        bos.flush();
        socket.shutdownInput();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("传输完毕");
        bw.newLine();
        bw.flush();

        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
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
