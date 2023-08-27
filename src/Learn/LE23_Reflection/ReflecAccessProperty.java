package Learn.LE23_Reflection;

/*
反射机制调用属性
反射机制静态属性的特殊使用
反射机制爆破调用私有属性
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> cls = Class.forName("Learn.LE23_Reflection.User");//获取Student类的Class对象
        Constructor<?> constructor = cls.getConstructor(int.class, String.class);
        Object o = constructor.newInstance(12, "男");

        //1.调用公有属性
        Field age = cls.getField( "age");
        age.set(o,11);
        System.out.println("age="+age.get(o));

        //2.调用私有属性
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"欢");
        System.out.println("传入对象的name="+name.get(o));
        System.out.println("传入null值的name="+name.get(null));//获取静态属性可以直接传入null不传入对象
    }

}

class User {
    public int age;
    public String gender;
    private static String name="崇";

    public User() {
    }

    public User(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    private User(int age) {
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
