package Learn.LE23_Reflection;

public class Cat {

    public String name="咪咪";
    public int age=11;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        System.out.println("Hi 对猫是怎么叫的");
    }

    public void cry() {
        System.out.println("呜呜呜...呜呜呜...");
    }
}
