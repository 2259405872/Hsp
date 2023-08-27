package Learn.LE23_Reflection;

/*
通过反射机制创建实例
反射调用构造器创建实例
反射爆破创建实例
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("Learn.LE23_Reflection.User");//获取Student类的Class对象

        //1.通过公有无参构造器获得Student实例
        Object o = cls.newInstance();//方法一
        Constructor<?> constructor1 = cls.getConstructor();
        Object o1 = constructor1.newInstance();//方法二

        System.out.println(o.toString());
        System.out.println(o1.toString());

        //2.通过公有参构造器获得实例
        Constructor<?> constructor2 = cls.getConstructor(int.class, String.class);
        Object o2 = constructor2.newInstance(12, "男");
        System.out.println(o2.toString());

        //3.反射爆破私有构造器创建实例
        Constructor<?> constructor3 = cls.getDeclaredConstructor(int.class);
        constructor3.setAccessible(true);//关闭检测机制实现暴力破解封装
        Object o3 = constructor3.newInstance(12);
        System.out.println(o3.toString());
    }
}

class Student{
    public int age;
    public String gender;
    private static String name;

    public Student() {
    }

    public Student(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    private Student(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                " gender="+gender +
                '}';
    }
}