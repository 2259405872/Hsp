package Learn.LE17;

//继承Thread类，创建线程
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 80; i++) {
            System.out.println("主线程"+i+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Cat extends Thread{
    int time=0;

    @Override
    public void run(){
        while (time<100){
            System.out.println("喵喵喵"+time+" 线程名："+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time++;
        }
    }

}