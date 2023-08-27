package smallProject.QQ01_Server.service;

import java.util.HashMap;

public class ManageServerConnectClientThread {
    private static HashMap<String,ServerConnectClientThread> hashMap=new HashMap<String,ServerConnectClientThread>();

    public static void addServerConnectClientThread(String userId,ServerConnectClientThread scct){
        hashMap.put(userId,scct);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hashMap.get(userId);
    }
}
