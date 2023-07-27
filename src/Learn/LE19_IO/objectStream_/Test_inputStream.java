package Learn.LE19_IO.objectStream_;

import Learn.LE19_IO.Dog;

import java.io.*;

public class Test_inputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/Learn/LE19_IO/a.dat");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        System.out.println(ois.readUTF());
        System.out.println(ois.readInt());
        Dog dog=(Dog)ois.readObject();//顺序顺序不能改变，否则会报错

        System.out.println(dog.getName());
        ois.close();
    }
}
