package Learn.LE17_Thread;

public class DeadLock {
    public static void main(String[] args) {
        DL d1=new DL(true);
        DL d2=new DL(false);
        d1.start();
        d2.start();
    }
}

class DL extends Thread {
    private boolean loop;
    private static final Object o1=new Object();
    private static final Object o2=new Object();

    public DL(boolean loop) {
        this.loop = loop;
    }
    @Override
    public void run() {
        while (true) {
            if (loop) {
                synchronized(o1){
                    System.out.println("o1:"+Thread.currentThread().getName());
                    loop=!loop;
                    synchronized(o2) {
                        System.out.println("o2:" + Thread.currentThread().getName());
                        loop = !loop;
                    }
                }
            }else {
                synchronized(o2){
                    System.out.println("o2:"+Thread.currentThread().getName());
                    loop=!loop;
                    synchronized(o1){
                        System.out.println("o1:"+Thread.currentThread().getName());
                        loop=!loop;
                    }
                }
            }
        }
    }
}