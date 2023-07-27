package Learn.LE19_IO;

import java.io.*;

public class PrintWriter_Test {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw1 = new PrintWriter(new FileWriter("src/Learn/LE19_IO/a.txt"));
        pw.print("Hello World!");
        pw.flush();//这里用flush不用close是因为使用close会关闭system.out那么后面的输出就输出不了了
        System.out.println("来来来来来来来");


        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);
        bw.write("hello world");
        bw.flush();
        bw.close();
    }
}
