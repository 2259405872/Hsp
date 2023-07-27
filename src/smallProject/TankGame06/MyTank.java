package smallProject.TankGame06;


class MyTank extends Tank {
    static final int type = 0;

    public MyTank(int x, int y) {
        super(x, y, 0);
    }

    public void shotEnemy(){
        if (shots.size()<5) {
            tankShot();
        }
    }//向敌人发射子弹，且子弹小于5枚
}
