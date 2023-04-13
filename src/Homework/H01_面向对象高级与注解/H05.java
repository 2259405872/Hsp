package Homework.H01_面向对象高级与注解;

public class H05 {
}

class A{
    private final String name="";
    {
        class B{
            private final static String name="";

            public void show(){
                System.out.println("A.name="+ A.this.name +"A.name="+name);
            }
        }
    }

}