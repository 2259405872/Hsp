package smallProject.QQ01_Client.service;

import java.util.HashMap;


//用一个HashMap管理线程
public class ManageClientConnectServerThread {
    private static HashMap <String,ClientConnectServerThread>hashMap=new HashMap<>();

    //添加一个线程
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread thread) {
        hashMap.put(userId,thread);
    }

    //通过userId获取线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hashMap.get(userId);
    }
}
