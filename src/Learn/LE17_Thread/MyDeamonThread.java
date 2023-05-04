package Learn.LE17_Thread;

public class MyDeamonThread {
    public static void main(String[] args) {
        DT dt = new DT();
        dt.setDaemon(true);//设置为守护进程
        dt.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在幸苦工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class DT extends Thread {

    @Override
    public void run() {
        for (;;) {
            System.out.println("马蓉宋喆在聊天，哈哈哈");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
