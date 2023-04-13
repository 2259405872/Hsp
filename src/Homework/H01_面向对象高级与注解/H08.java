package Homework.H01_面向对象高级与注解;

public class H08 {
}

enum Color implements inter{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public void show(){
        System.out.println("redValue="+redValue+"greenValue="+greenValue+"blueValue"+blueValue);
    }
}

interface inter{
    void show();
}