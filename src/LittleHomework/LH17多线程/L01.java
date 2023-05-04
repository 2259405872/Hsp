package LittleHomework.LH17多线程;

public class L01 {
    public static void main(String[] args) {

        for (int i = 1; i <=10 ; i++) {
            System.out.println("hi " + i);
            if (i == 5) {
                try {
                    T t = new T();
                    Thread t1 = new Thread(t);
                    t1.start();
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                System.out.println("主线程结束");
            }
        }
    }
}

class T implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=10 ; i++) {
            System.out.println("hello "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                System.out.println("子线程结束");
            }
        }
    }
}