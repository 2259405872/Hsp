package Learn.LE21_WebCode;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local.getHostAddress());

        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu.getHostAddress());
    }
}
