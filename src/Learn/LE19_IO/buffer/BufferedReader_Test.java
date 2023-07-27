package Learn.LE19_IO.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_Test {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new FileReader("src/Learn/LE19_IO/a.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.print(line);//.readline读取的字符串不包括换行符
        }
        reader.close();//关闭缓冲流同时也关闭了处理流

    }
}
