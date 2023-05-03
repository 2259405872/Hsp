package Learn.LE17_Thread;

//实现Runnable接口，创建线程
public class Thread02 {
    public static void main(String[] args) {
        Tiger t=new Tiger();
        Thread t1=new Thread(t);
        t1.start();
        for (int i = 0; i < 80; i++) {
            System.out.println("主线程"+i+" 线程名:"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Animal{}

class Tiger extends Animal implements Runnable{
    int time=0;
    @Override
    public void run() {
        while (time<80){
            System.out.println("嗷嗷嗷!"+time+" 线程名:"+Thread.currentThread().getName());
            time++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
