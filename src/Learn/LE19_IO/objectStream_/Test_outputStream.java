package Learn.LE19_IO.objectStream_;

import Learn.LE19_IO.Dog;

import java.io.*;

public class Test_outputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Learn/LE19_IO/a.dat");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeUTF("hello");
        oos.writeInt(100);
        oos.writeObject(new Dog("yuan",14,"red"));
        oos.flush();
        oos.close();
    }
}
