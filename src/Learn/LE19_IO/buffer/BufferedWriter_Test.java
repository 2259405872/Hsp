package Learn.LE19_IO.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Learn/LE19_IO/b.txt",true));

        writer.write("hello world");
        writer.newLine();//换行符
        writer.write("你好，世界");
        writer.flush();
        writer.close();
    }
}
