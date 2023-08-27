package smallProject.QQ01_Client.view;

import smallProject.QQ01_Client.service.UserClientService;
import smallProject.QQ01_Client.utils.Utility;

public class QQView {
    boolean loop = true;
    String key = "";
    String userId;
    String pwd;
    UserClientService userClientService=new UserClientService();

    public static void main(String[] args) {
        QQView view = new QQView();
        view.mainMenu();
    }
    public void mainMenu() {
        while (loop) {
            System.out.println("======欢迎登录网络通讯系统======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择:");
            key=Utility.readString(1);

            switch (key) {
                case "1"://选择登录
                    System.out.println("请输入用户号:");
                    userId=Utility.readString(50);
                    System.out.println("请输入密  码:");
                    pwd=Utility.readString(50);

                    if(userClientService.checkUser(userId,pwd)){
                        System.out.println("======欢迎(用户 "+userId+")登录成功======");
                        secondMenu();//进入二级菜单
                    }else {
                        System.out.println("登录失败，请重新登录");
                    }
                    break;
                case "9"://选择退出
                    loop=false;
                    break;
            }
        }
    }

    //二级菜单
    public void secondMenu(){
        while (loop){
            System.out.println("======网络通讯系统二级菜单(用户 "+userId+")======");
            System.out.println("\t\t 1 显示在线用户列表");
            System.out.println("\t\t 2 群发消息");
            System.out.println("\t\t 3 私聊消息");
            System.out.println("\t\t 4 发送文件");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择:");
            key=Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.println("显示用户列表信息");
                    break;
                case "2":
                    System.out.println("群发消息");
                    break;
                case "3":
                    System.out.println("私聊消息");
                    break;
                case "4":
                    System.out.println("发送文件");
                    break;
                case "9":
                    loop=false;
                    break;
            }
        }
    }

}
