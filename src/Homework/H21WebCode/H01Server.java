package Homework.H21WebCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class H01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        socket.shutdownInput();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if(str.equals("name")) {
            bw.write("你好杨山");
        }else if(str.equals("hobby")) {
            bw.write("编写JAVA程序");
        }else {
            bw.write("你在说什么");
        }
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
