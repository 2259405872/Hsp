package smallProject.TankGame06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

class MyPanel extends JPanel implements KeyListener,Runnable {
    private MyTank myTank = null;
    private int enemyTankSize = 3;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private Vector<Bomb> bombs=new Vector<>();
    Image image1=null;
    Image image2=null;
    Image image3=null;

    public MyPanel(int key) {
        //我方坦克
        this.myTank = new MyTank(100, 100);
        //敌人坦克
        switch (key){
            case 1://当开始新游戏时
                Recorder.setEnemyTanks(enemyTanks);
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemy=new EnemyTank((i + 1) * 100, 0);
                    enemy.friendTanks=enemyTanks;
                    enemyTanks.add(enemy);
                    Thread thread = new Thread(enemy);
                    thread.start();
                    Shot shot = new Shot(enemy.getX() + 18, enemy.getY() + 60, 2);
                    shot.start();
                }
                break;
            case 2://当继续上局游戏时
                try {
                    Recorder.getInfo();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                enemyTanks=Recorder.getEnemyTanks();
                enemyTankSize=enemyTanks.size();
                break;
        }

        //爆炸的三张图片
        image1=Toolkit.getDefaultToolkit().createImage(Panel.class.getResource("/bomb03.png"));
        image2=Toolkit.getDefaultToolkit().createImage(Panel.class.getResource("/bomb03.png"));
        image3=Toolkit.getDefaultToolkit().createImage(Panel.class.getResource("/bomb03.png"));
    }

    //显示游戏数据
    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("您累计击毁敌方坦克",1020,20);
        drawTank(1020,40,g,0,1 );
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum()+"",1070,70);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //设置背景
        showInfo(g);
        //显示我方当前游戏数据

        if (myTank.isLive()) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), MyTank.type);//画我方坦克
        }

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank e=enemyTanks.get(i);
            if (e.isLive()) {
                drawTank(e.getX(), e.getY(), g, e.getDirect(), EnemyTank.type);//画坦克
                for (int j = 0; j < e.shots.size(); j++) {
                    Shot s=e.shots.get(j);
                    if (s.isLive) {
                        g.fill3DRect(s.x,s.y,4,4,false);//画子弹
                    } else {
                        //子弹死亡删除子弹
                        e.shots.remove(s);
                        j--;
                    }
                }
            } else {
                //坦克死亡则删除坦克
                enemyTanks.remove(i);
                enemyTankSize--;
                Recorder.addAllEnemyTankNum();
                i--;
            }
        }//画敌方坦克机器子弹


        for (int i = 0; i < myTank.shots.size(); i++) {
            Shot s = myTank.shots.get(i);
            if (s.isLive) {
                g.setColor(Color.yellow);
                g.fill3DRect(s.x, s.y, 4, 4, false);//画子弹
            } else {
                //子弹死亡删除子弹
                myTank.shots.remove(s);
                i--;
            }//画我方坦克子弹
        }

        for (int i = 0; i < bombs.size(); i++) {
                Bomb b=bombs.get(i);
                if (b.isLive) {
                    if (b.life>6){
                        g.drawImage(image1,b.x,b.y,60,60, null);
                    }else if (b.life>3){
                        g.drawImage(image2,b.x,b.y,60,60, null);
                    } else{
                        g.drawImage(image3,b.x,b.y,60,60, null);
                    }
                    b.lifeDown();
                } else {
                    //爆炸死亡删除爆炸
                    bombs.remove(i);
                    i--;
                }
        }//画爆炸
    }

    /**
     * @param x      坦克左上角横坐标
     * @param y      坦克左上角纵坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.green);
                break;
            case 1://敌方坦克
                g.setColor(Color.red);
                break;
        }
        //direct=0,1,2,3(上，右，下，左)
        switch (direct) {
            case 0://坦克方向向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://方向向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://方向向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3://方向向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override//设置按键盘的事件
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (myTank.getY()-myTank.getSpeed()>0) {
                myTank.setDirect(0);
                myTank.moveUp();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (myTank.getY()+myTank.getSpeed()+60<750) {
                myTank.setDirect(2);
                myTank.moveDown();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (myTank.getX()-myTank.getSpeed()>0) {
                myTank.setDirect(3);
                myTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (myTank.getX()+myTank.getSpeed()+60<1000) {
                myTank.setDirect(1);
                myTank.moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shotEnemy();
        }//发射子弹
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void hitTank(Shot s, Tank e) {
        switch (e.getDirect()) {
            case 0:
            case 2:
                if(s.x-e.getX()<=40&&s.x-e.getX()>=0&&s.y-e.getY()<=60&&s.y-e.getY()>=0){
                    e.kill();
                    s.isLive=false;
                    bombs.add(new Bomb(e.getX(),e.getY()));
                }
                break;
            case 3:
            case 1:
                if(s.x-e.getX()<=60&&s.x-e.getX()>=0&&s.y-e.getY()<=40&&s.y-e.getY()>=0){
                    e.kill();
                    s.isLive=false;
                    bombs.add(new Bomb(e.getX(),e.getY()));
                }
                break;
        }
    }////判断是否击中坦克，并杀死

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < enemyTankSize; i++) {
                EnemyTank e=enemyTanks.get(i);
                for (int j = 0; j < myTank.shots.size(); j++) {
                    Shot s=myTank.shots.get(j);
                    if(s!=null&&s.isLive){
                        hitTank(s,e);
                    }
                }//判断我方坦克是否击中敌方坦克

                for (int j = 0; j < e.shots.size(); j++) {
                    Shot s=e.shots.get(j);
                    if(s!=null&&s.isLive){
                        hitTank(s,myTank);
                    }
                }//判断地方敌方坦克是否击中我方坦克
            }

            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
