package Learn.LE17_Thread;

public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        t.setRunning(true);
        t.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //通过修改running变量让线程终止
        t.setRunning(false);
    }
}

class T extends Thread {
    private boolean running = true;//控制了线程是否运行
    @Override
    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName()+"正在运行中");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
