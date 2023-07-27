package Homework.H21WebCode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class H01Client {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入你的指令：");
        String str = input.next();

        Socket socket = new Socket(InetAddress.getByName("10.201.150.248"),9999);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(str);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str1 = br.readLine();
        System.out.println(str1);

        br.close();
        bw.close();
        socket.close();
    }
}
