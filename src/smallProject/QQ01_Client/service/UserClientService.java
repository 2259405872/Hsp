package smallProject.QQ01_Client.service;

import smallProject.QQ01_Client.common.Message;
import smallProject.QQ01_Client.common.MessageType;
import smallProject.QQ01_Client.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetAddress;
import java.net.Socket;


//用于实现客户端的各种服务
public class UserClientService {
    private User user=new User();
    private Socket socket;

    //验证登录信息的服务
    public boolean checkUser(String userId, String pwd){
        user.setUserid(userId);
        user.setPassword(pwd);

        try {
            //连接到服务器
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);

            //上传user信息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            //获取服务器发送的验证消息
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message =(Message)ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {
                //登录成功启动监听服务器的线程，接收来自服务器的消息
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                ccst.start();

                //将线程加入ManageClientConnectServerThread方便管理和拓展
                ManageClientConnectServerThread.addClientConnectServerThread(userId,ccst);
                return true;
            }else {
                socket.close();
                return false;
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
