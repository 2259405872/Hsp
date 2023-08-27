package Learn.LE23_Reflection.class_;

/*
获取Class对象的六种方式
*/

public class Test_Class02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName多用于读取文件中类的全路径，加载类 ；也是动态加载的主要实现方式
        String classAllPath= "Learn.LE23_Reflection.class_.Car";//通常通过文件读取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2.通过类名.class获取,通常用于参数的传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //3.对象.getClass获取，通常用于有对象的实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();

        //4.通过类加载器(总共有四种类加载器)来获取，
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //5.基本数据通过.class类型获取Class类对象
        Class<Integer> cls5 = int.class;
        Class<Boolean> cls6 = boolean.class;
        System.out.println(cls5);
        System.out.println(cls6);

        //5.基本数据类型通过.TYPE获取Class类对象
        Class<Integer> cls7 = Integer.TYPE;
        Class<Character> cls8 = Character.TYPE;
        System.out.println(cls7);
        System.out.println(cls8);
    }

}
