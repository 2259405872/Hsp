package Homework.H01_面向对象高级与注解;

public class H06 {
    public static void main(String[] args) {
        Person Tang=new Person("唐僧",VehicleFactory.getHorse());
    }
}
interface Vehicles{
    public void work();
}
//交通工具接口类

class Horse implements Vehicles{

    @Override
    public void work() {
        System.out.println("小马跑呀跑");
    }
}
//马类

class Boat implements Vehicles{

    @Override
    public void work() {
        System.out.println("小船慢慢滑");
    }
}
//船类

class VehicleFactory{
    public static Horse getHorse(){
        return new Horse();
    }

    public static Boat getBoat(){
        return new Boat();
    }
}

class Person{
    private String name;
    private Vehicles vehicle;

    public Person(String name, Vehicles vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void passRiver(){
        if(!(vehicle instanceof Boat)){
            vehicle=VehicleFactory.getBoat();
        }
        vehicle.work();
    }

    public void common() {
        if(!(vehicle instanceof Horse)){
            vehicle=VehicleFactory.getHorse();
        }
        vehicle.work();
    }
}
//人类



