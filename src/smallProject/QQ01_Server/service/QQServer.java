package smallProject.QQ01_Server.service;

import smallProject.QQ01_Server.common.Message;
import smallProject.QQ01_Server.common.MessageType;
import smallProject.QQ01_Server.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    private ServerSocket ss;

    public QQServer() {
        System.out.println("服务端9999端口监听中");
        try {
            this.ss = new ServerSocket(9999);

            //通过循环持续监听端口实现与多个客户端建立连接
            while (true) {
                Socket socket = ss.accept();

                //获取user
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();

                //创建发送回客户端的对象
                Message message = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //验证用户信息是否正确
                if (user.getUserid().equals("100")&&user.getPassword().equals("123456")){
                    //登录通过
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCESS);

                    //启动与客户端通讯的线程
                    ServerConnectClientThread scct = new ServerConnectClientThread(user.getUserid(), socket);
                    scct.start();

                    //将线程加入管理线程的集合方便管理
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserid(),scct);
                }else {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    socket.close();
                }

                //向客户端发送登录验证信息
                oos.writeObject(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            //如果服务端退出while循环,说明服务器端不再监听关闭SercverSocket
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
