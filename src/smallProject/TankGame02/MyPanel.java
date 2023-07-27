package smallProject.TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

class MyPanel extends JPanel implements KeyListener {
    private MyTank myTank = null;
    private int enemyTankSize = 3;
    private Vector<EnemyTank> enemyTanks = new Vector<>();

    public MyPanel() {
        this.myTank = new MyTank(100, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank((i + 1) * 100, 0));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        g.fillRect(0, 0, 1000, 750);
        //设置背景

        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), MyTank.type);//我方坦克

        for (EnemyTank i : enemyTanks) {
            drawTank(i.getX(), i.getY(), g, i.getDirect(), EnemyTank.type);
        }//画敌方坦克
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
            myTank.setDirect(0);
            myTank.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            myTank.moveRight();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
