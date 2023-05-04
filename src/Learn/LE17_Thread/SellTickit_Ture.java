package Learn.LE17_Thread;

public class SellTickit_Ture {
    public static void main(String[] args) {
        TicketSell01 t=new TicketSell01();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

class TicketSell01 implements Runnable {
    private int count = 1000;
    private boolean loop = true;

    public synchronized void sell() {
        if (count <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "正在售票，剩余" + count + "张票");
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
