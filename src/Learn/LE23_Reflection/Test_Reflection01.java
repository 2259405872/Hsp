package Learn.LE23_Reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;


/*
* 反射机制的初始案例
*
* 反射实现了能通过更改文件中的数据，而不更改源码的条件下，更改调用的类或者方法
* 比如说，把文件re.peroperties的method改成cry，调用的方法也就改变了
* */
public class Test_Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //一般使用类和其方法
        Cat cat = new Cat();
        cat.hi();
        //反射使用类和方法

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


        /*反射实现了能通过更改文件中的数据，而不更改源码的条件下，更改调用的类或者方法
        比如说，把文件re.peroperties的method改成cry，调用的方法也就改变了
        */
    }
}
