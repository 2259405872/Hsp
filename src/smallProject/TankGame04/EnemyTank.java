package smallProject.TankGame04;


import java.util.Vector;

class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots=new Vector<Shot>();//存放子弹
    static final int type = 1;

    public EnemyTank(int x, int y) {
        super(x, y, 2);
    }


    //控制敌人随机移动
    @Override
    public void run() {
        while (isLive()) {
            setDirect((int)(Math.random()*4));//随机生成方向
            //按方向移动
            switch (getDirect()) {
                case 0:
                    for (int i=0; i<30; i++) {
                        if (getY()-getSpeed()>0) {
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
                        if (getX()+getSpeed()+60<1000) {
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
                        if (getY()+getSpeed()+60<750) {
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
                        if (getX()-getSpeed()>0) {
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
            }
        }
    }
}
