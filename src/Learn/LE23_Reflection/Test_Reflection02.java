package Learn.LE23_Reflection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
*测试反射机制的相关类:
* Class
*
* Field
* Constructor
* Method
*/
public class Test_Reflection02 {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //读取数据
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Learn/LE23_Reflection/re.properties"));
        String path=properties.get("classpath").toString();
        String methodName=properties.get("method").toString();

        //利用反射调用方法.hi()
        //1）加载类返回Class对象
        Class cls=Class.forName(path);
        //2）利用cls对象.newInstance()的方法得到path所表示的类
        Cat cat1 = (Cat) cls.newInstance();
        //3)通过cls的.getMethod()方法得到Cat类中的方法
        Method method=cls.getMethod(methodName);
        //4)通过Method的.invoke()方法运行.hi()方法
        method.invoke(cat1);

        //反射机制的相关类

        //1)获取成员变量的类Field
        Field name=cls.getField("name");//得到了Cat类里的name字段
        System.out.println(name);

        //2)获取构造器的类Constructor
        Constructor constructor=cls.getConstructor();//得到了Cat类的无参构造器
        Constructor constructor1=cls.getConstructor(String.class);//得到了有参数的构造器
        System.out.println(constructor);
        System.out.println(constructor1);


    }

}
