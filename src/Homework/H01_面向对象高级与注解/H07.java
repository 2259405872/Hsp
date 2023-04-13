package Homework.H01_面向对象高级与注解;

public class H07 {
}
class Car{
    private int temprature;

    public Car(int temprature) {
        this.temprature = temprature;
    }

    class Air{
        public void flow(){
            if (temprature > 40) {
                System.out.println("吹冷气");
            } else if (temprature<0) {
                System.out.println("吹暖气");
            }else {
                System.out.println("正常温度吹个鬼");
            }
        }
    }
}
