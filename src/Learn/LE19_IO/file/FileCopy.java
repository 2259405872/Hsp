package Learn.LE19_IO.file;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File file1 = new File("src/Learn/LE19_IO/a.txt");
        File file2 = new File("src/Learn/LE19_IO/b.txt");

        FileInputStream fis= null;
        FileOutputStream fos=null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2,true);
            byte[] buffer = new byte[3];
            int len;

            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis !=null) {
                    fis.close();
                }
                if (fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void test(){

    }
}
