package Learn.LE23_Reflection;

/*
反射机制相比传统机制的效率，以及提升效率的方法

总体来说，传统方法比反射快很多
反射在方法变量等调用时，可以用.setAccessible(true)取消访问检查，从而提高效率，但不是很明显
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test_Reflection03 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Test_Reflection03 t = new Test_Reflection03();
        long r1 = t.m1();
        long r2 = t.m2();
        System.out.println(r1);
        System.out.println(r2);
    }

    //传统的方法
    public long m1(){
        Cat cat = new Cat();

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            cat.hi();
        }
        long l2 = System.currentTimeMillis();

        long l = l2 - l1;
        return l;
    }

    //反射机制调用类和方法
    public long m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("Learn.LE23_Reflection.Cat");
        Object cat1 = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);//在方法调用时取消访问检查，从而提高效率，但不是很明显

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            hi.invoke(cat1);
        }
        long l2 = System.currentTimeMillis();

        long l = l2 - l1;
        return l;
    }
}
