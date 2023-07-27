package Learn.LE19_IO;

import java.io.Serializable;

public class Dog implements Serializable {
    public String name;
    public int age;
    public String color;

    public Dog(String name, int age,String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
