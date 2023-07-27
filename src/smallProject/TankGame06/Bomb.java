package smallProject.TankGame06;

public class Bomb {
    int x, y;
    int life=9;
    boolean isLive=true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减生命值，最后死亡
    public void lifeDown() {
        if(life>0){
            life--;
        }else {
            isLive=false;
        }
    }
}
