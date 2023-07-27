package Learn.LE19_IO.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) throws IOException {
        String filepath="src/Learn/LE19_IO/hello.txt";

        FileInputStream fis = null;
        fis = new FileInputStream(filepath);

        /*int re=0;
        while ((re=fis.read())!=-1){
            System.out.print((char)re);
        }
        */

        byte[] b=new byte[3];
        int len=0;
        while ((len=fis.read(b))!=-1){
            System.out.print(new String(b,0,len));
        }
        fis.close();

    }
}
