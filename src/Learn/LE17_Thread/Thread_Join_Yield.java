package Learn.LE17_Thread;

public class Thread_Join_Yield {
    public static void main(String[] args) {
        T04 t=new T04();
        t.start();

        for (int i=1; i<=20;i++){
            System.out.println("主线程(小弟)吃了第"+i+"个包子");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5){
                System.out.println("老大先吃");
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class T04 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程(老大)吃了第"+i+"个包子");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
