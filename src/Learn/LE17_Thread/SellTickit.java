package Learn.LE17_Thread;

//多线程实现自动售票（当前存在超卖的问题）
public class SellTickit {
    public static void main(String[] args) {
        TicketSell ticketSell = new TicketSell();
        for(int i = 0; i < 3; i++){
            new Thread(ticketSell).start();
        }
    }
}

class TicketSell implements Runnable{
    private int count = 100;

    @Override
    public void run() {
        while(true){
            if(count<0){
                System.out.println("售票结束");
                break;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "正在售票，剩余" + count + "张票");
        }
    }
}
