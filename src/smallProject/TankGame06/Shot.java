package smallProject.TankGame06;

public class Shot extends Thread {
    int x, y;//子弹的坐标
    int speed=2;//子弹的速度
    int direct;//子弹的方向
    boolean isLive=true;

    public Shot(int x, int y,int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
    }

    @Override
    public void run() {
        while (isLive) {
            switch (direct){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }//上右下左，移动轨迹

            if(!(x>=0&&x<=1000&&y>=0&&y<=750)){
                isLive=false;
                break;
            }//子弹超出边界，停止运行


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
