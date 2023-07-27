package smallProject.TankGame04;


class MyTank extends Tank {
    static final int type = 0;
    Shot shot=null;

    public MyTank(int x, int y) {
        super(x, y, 0);
    }

    public void shotEnemy(){
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
    }
}
