package Learn.LE19_IO.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Learn/LE19_IO/a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);
        fos.write("hello".getBytes());
        fos.close();

        FileOutputStream fos1 = new FileOutputStream(file,true);
        fos1.write(" world!".getBytes());
        fos1.close();
    }
}
