package Homework.H19IO流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class H01 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("src/HomeWork/H19IO流/mytemp");
        if (!file1.exists()) {
            file1.mkdir();
        }

        File file2 = new File("src/HomeWork/H19IO流/mytemp/hello.txt");

        if (!file2.exists()) {
            file2.createNewFile();
        }

        FileWriter writer = new FileWriter(file2);
        writer.write("hello~");
        writer.close();
    }
}
