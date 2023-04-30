package Homework.H14集合;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class H02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 4000000);
        Car car2 = new Car("宾利", 50000);
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(car2);
        cars.add(car);

        cars.remove(car);

        System.out.println(cars.contains(car2));

        System.out.println(cars.size());

        System.out.println(cars.isEmpty());


    }
}
class Car{
    private String name;
    private double price;

    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Test
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}