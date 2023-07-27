package smallProject.TankGame03;

import smallProject.TankGame02.Tank;

class EnemyTank extends Tank {
    static final int type = 1;

    public EnemyTank(int x, int y) {
        super(x, y, 2);
    }
}
