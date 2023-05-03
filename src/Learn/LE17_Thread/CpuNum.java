package Learn.LE17_Thread;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime=Runtime.getRuntime();

        int cpunum=runtime.availableProcessors();
        System.out.println("这台电脑有"+cpunum+"个核心");
    }
}
