package smallProject.TankGame05;

import java.util.Vector;

public class Tank {
    private int x, y;//坦克的横纵坐标
    private int direct;//坦克的方向
    private int speed;//坦克的速度
    private boolean isLive=true;//坦克是否活着

    Vector<Shot> shots=new Vector<Shot>();//存放子弹的弹夹
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

    public boolean isLive() {
        return isLive;
    }

    public void kill() {
        isLive = false;
    }

    public void tankShot(){
        Shot shot=null;
        switch(getDirect()){
            case 0:
                shot = new Shot(getX()+18, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX()+60, getY()+18, 1);
                break;
            case 2:
                shot = new Shot(getX()+18, getY()+60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY()+18, 3);
                break;
        }
        shots.add(shot);
        shot.start();
    }//装填，发射子弹
}

