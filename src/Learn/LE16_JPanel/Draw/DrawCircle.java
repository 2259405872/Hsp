package Learn.LE16_JPanel.Draw;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends Panel{
    @Override
    public void paint(Graphics g){
        super.paint(g);//调用父类的paint方法完成初始化
        g.drawOval(10,10,100,100);
        g.setColor(Color.RED);
        g.fillOval(10,10,100,100);

//        Image img= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:/Saved Pictures/anime-girl-1275977-wallhere.com.jpg"));
//        g.drawImage(img,0,0,192,122,this);
        g.setColor(Color.blue);
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("日本国旗",100,200);

    }
}
