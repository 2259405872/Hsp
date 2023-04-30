package Learn.LE16_JPanel;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(400,400);
        this.setVisible(true);
    }
}

class MyPanel extends Panel{
    @Override
    public void paint(Graphics g){
        super.paint(g);//调用父类的paint方法完成初始化
        g.drawOval(10,10,100,100);

    }
}
