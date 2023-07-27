package smallProject.TankGame06;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyTankNum = 0;//我方击毁敌方坦克数
    private static Vector<EnemyTank> enemyTanks = null;//敌方坦克列表
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recoderPath = "src/smallProject/TankGame06/recorder.txt";

    //获取击毁的敌人坦克数量
    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //增加击毁数量
    public static void addAllEnemyTankNum() {
        allEnemyTankNum++;
    }

    //保存记录
    public static void keepRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recoderPath));
        bw.write(allEnemyTankNum + "\n");
        for (EnemyTank e : enemyTanks) {
            if (e.isLive()) {
                String enemyinfo = e.getX() + " " + e.getY() + " " + e.getDirect() + "\n";
                bw.write(enemyinfo);
            }
        }
        bw.close();
    }

    public static void getInfo() throws IOException {
        br = new BufferedReader(new FileReader(recoderPath));

        allEnemyTankNum = Integer.parseInt(br.readLine());

        enemyTanks = new Vector<>();
        String str;
        while ((str = br.readLine()) != null) {
            String[] enemyinfo = str.split(" ");
            EnemyTank e = new EnemyTank(Integer.parseInt(enemyinfo[0]), Integer.parseInt(enemyinfo[1]), Integer.parseInt(enemyinfo[2]));
            enemyTanks.add(e);
            e.friendTanks = Recorder.enemyTanks;
            Thread t=new Thread(e);
            t.start();
        }
        br.close();
    }
        public static Vector<EnemyTank> getEnemyTanks () {
            return enemyTanks;

    }
}