package smallProject.QQ01_Client.service;

import smallProject.QQ01_Client.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


//监听服务器的线程，接收来自服务器的消息

public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //无限循环，线程不断监听服务器的消息
        while (true) {
            try {
                System.out.println("读取新消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//没有数据发过来线程就会阻塞在这里
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
