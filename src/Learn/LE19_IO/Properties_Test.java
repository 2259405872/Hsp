package Learn.LE19_IO;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_Test {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        //保存或修改properties文件
        properties.setProperty("name", "崇");
        properties.setProperty("charset", "UTF-8");
        properties.setProperty("ip", "127.0.0.1");

        properties.store(new FileOutputStream("src/Learn/LE19_IO/c.properties"),"这里写注释");

        //读取properties文件
        properties.load(new FileReader("src/Learn/LE19_IO/c.properties"));
        System.out.println(properties.getProperty("name"));
        properties.list(System.out);
    }
}
