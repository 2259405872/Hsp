package Homework.H17线程;

public class H02 {
    public static void main(String[] args) {
        C c1 = new C();
        new Thread(c1).start();
        new Thread(c1).start();
    }
}

class C implements Runnable{
    private static int account =10000;
    @Override
    public synchronized void run() {
            while (true) {
                if (account==0){
                    System.out.println("余额不足");
                    break;
                }
                account-=100;
                System.out.println(Thread.currentThread().getName() + "取钱:100,余额" + account);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
