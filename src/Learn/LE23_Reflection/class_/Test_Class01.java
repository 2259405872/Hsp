package Learn.LE23_Reflection.class_;

/*
Class类的常用方法
*/

import java.lang.reflect.Field;

public class Test_Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath="Learn.LE23_Reflection.class_.Car";
        //1.获取Car类对应的Class对象
        //<?>表示未知类型
        Class<?> cls = Class.forName(classAllPath);

        //2.输出cls
        System.out.println(cls);//显示Car类的全路径
        System.out.println(cls.getClass());//显示cls的运行类型

        //3.获取包名
        System.out.println(cls.getPackage());//输出Car类的包名

        //4.得到全类名
        System.out.println(cls.getName());

        //5.获取对象实例
        Object o = cls.newInstance();
        System.out.println(o.toString());

        //6.通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(o));//输出初始值宝马

        //7.通过反射给属性赋值
        brand.set(o,"奔驰");
        System.out.println(brand.get(o));

        //8.得到所有的属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName()+"="+field.get(o));
        }

    }
}
