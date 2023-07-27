package smallProject.TankGame06;


import java.util.Vector;

class EnemyTank extends Tank implements Runnable{
    static final int type = 1;
    Vector<EnemyTank> friendTanks;

    public EnemyTank(int x, int y) {
        super(x, y, 2);
    }
    public EnemyTank(int x, int y, int direct){
        super(x, y, direct);
    }

    public void shotHero(){
        if (shots.size()<1) {
            tankShot();
        }
    }//射击我方坦克，当弹夹里没有子弹时添加子弹

    //判断是否将和友方碰撞
    public boolean isTouchedFriend(){
        int x = this.getX();
        int y = this.getY();
        for (EnemyTank friend: friendTanks){
            int x2 = friend.getX();
            int y2 = friend.getY();
            if (friend!=this){
                switch (this.getDirect()) {
                    case 0:
                        switch (friend.getDirect()){
                            case 0:
                            case 2:
                                return (x>x2&&x<x2+40&&y>y2&&y<y2+60)||(x+40>x2&&x+40<x2+40&&y>y2&&y<y2+60);
                            case 1:
                            case 3:
                                return (x>x2&&x<x2+60&&y>y2&&y<y2+40)||(x+40>x2&&x+40<x2+60&&y>y2&&y<y2+40);
                        }
                        break;
                    case 1:
                        switch (friend.getDirect()){
                            case 0:
                            case 2:
                                return (x+60>x2&&x+60<x2+40&&y>y2&&y<y2+60)||(x+60>x2&&x+60<x2+40&&y+40>y2&&y+40<y2+60);
                            case 1:
                            case 3:
                                return (x+60>x2&&x+60<x2+60&&y>y2&&y<y2+40)||(x+60>x2&&x+60<x2+60&&y+40>y2&&y+40<y2+40);
                        }
                        break;
                    case 2:
                        switch (friend.getDirect()){
                            case 0:
                            case 2:
                                return (x>x2&&x<x2+40&&y+60>y2&&y+60<y2+60)||(x+40>x2&&x+40<x2+40&&y+60>y2&&y+60<y2+60);
                            case 1:
                            case 3:
                                return (x>x2&&x<x2+60&&y+60>y2&&y+60<y2+40)||(x+40>x2&&x+40<x2+60&&y+60>y2&&y+60<y2+40);
                        }
                        break;
                    case 3:;
                        switch (friend.getDirect()){
                            case 0:
                            case 2:
                                return (x>x2&&x<x2+40&&y>y2&&y<y2+60)||(x>x2&&x<x2+40&&y+40>y2&&y+40<y2+60);
                            case 1:
                            case 3:
                                return (x>x2&&x<x2+60&&y>y2&&y<y2+40)||(x>x2&&x<x2+60&&y+40>y2&&y+40<y2+40);
                        }
                        break;
                }
            }
        }
        return false;
    }

    //控制敌人随机移动
    @Override
    public void run() {
        while (isLive()) {
            setDirect((int)(Math.random()*4));//随机生成方向

            switch (getDirect()) {
                case 0:
                    for (int i=0; i<30; i++) {
                        if (getY()-getSpeed()>0&&!isTouchedFriend()) {
                            moveUp();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i=0; i<30; i++) {
                        if (getX()+getSpeed()+60<1000&&!isTouchedFriend()) {
                            moveRight();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i=0; i<30; i++) {
                        if (getY()+getSpeed()+60<750&&!isTouchedFriend()) {
                            moveDown();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i=0; i<30; i++) {
                        if (getX()-getSpeed()>0&&!isTouchedFriend()) {
                            moveLeft();
                        } else {
                            break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }//按方向移动

            shotHero();//射击
        }
    }
}
