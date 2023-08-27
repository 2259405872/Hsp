package Learn.LE23_Reflection.class_;

public class Car {
    public String brand="宝马";
    public String color="白色";
    public int price=1000000;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
