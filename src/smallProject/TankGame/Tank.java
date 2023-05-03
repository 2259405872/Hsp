package smallProject.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Tank {
    private int x, y;//坦克的横纵坐标
    private int direct;//坦克的方向
    private int speed;//坦克的速度




    public Tank(int x, int y,int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = 3;
    }

    //向上移动
    public void moveUp(){
        this.y -= this.speed;
    }

    //向下移动
    public void moveDown(){
        this.y += this.speed;
    }

    //向左移动
    public void moveLeft(){
        this.x -= this.speed;
    }

    //向右移动
    public void moveRight(){
        this.x += this.speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class MyTank extends Tank{
    static final int type=0;
    public MyTank(int x, int y) {
        super(x, y,0);
    }
}

class EnemyTank extends Tank{
    static final int type=1;

    public EnemyTank(int x, int y) {
        super(x, y, 2);
    }
}

class MyPanel extends JPanel implements KeyListener {
    private MyTank myTank=null;
    private int enemyTankSize=3;
    private Vector<EnemyTank> enemyTanks=new Vector<>();

    public MyPanel() {
        this.myTank = new MyTank(100,100);
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank((i+1)*100,0));
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750);
        g.fillRect(0,0,1000,750);
        //设置背景

        drawTank(myTank.getX(),myTank.getY(),g,myTank.getDirect(), MyTank.type);//我方坦克

        for (EnemyTank i: enemyTanks) {
            drawTank(i.getX(),i.getY(),g,i.getDirect(),EnemyTank.type);
        }//画敌方坦克
    }

    /**
     *
     * @param x 坦克左上角横坐标
     * @param y 坦克左上角纵坐标
     * @param g 画笔
     * @param direct 坦克方向
     * @param type 坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
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
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1://方向向右
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.drawOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2://方向向下
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3://方向向左
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.drawOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            myTank.setDirect(0);
            myTank.moveUp();
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            myTank.setDirect(2);
            myTank.moveDown();
        }
        if(e.getKeyCode()==KeyEvent.VK_A){
            myTank.setDirect(3);
            myTank.moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_D){
            myTank.setDirect(1);
            myTank.moveRight();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class TankGame01 extends JFrame{
    MyPanel mp=null;

    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
    }

}
