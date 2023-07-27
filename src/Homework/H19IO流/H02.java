package Homework.H19IO流;

import java.io.*;

public class H02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Learn/LE19_IO/Dog.java"));
        int i=0;
        String src;
        while ((src=reader.readLine())!=null) {
            System.out.println(i+" " + src);
            i++;
        }
        reader.close();

    }
}
