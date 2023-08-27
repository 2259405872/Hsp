package smallProject.QQ01_Server.service;

import smallProject.QQ01_Client.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//监听客户端的线程，接收来自客户端的消息
public class ServerConnectClientThread extends Thread {
    private String userId;//用户Id
    private Socket socket;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //不断读取来自客户端的消息
                System.out.println("服务端正在等待读取来自客户端("+userId+")的数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
