package Homework.H19IO流;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

public class H03 {

    public static void main(String[] args) throws IOException {
        File file1 = new File("src/Homework/H19IO流/mytemp/dog.properties");
        File file2 = new File("src/Homework/H19IO流/mytemp/hhh.txt");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(Files.newInputStream(file1.toPath())));

        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file2.toPath()));

        oos.writeObject(dog);

    }
}
