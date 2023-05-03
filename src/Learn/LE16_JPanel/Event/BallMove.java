package Learn.LE16_JPanel.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    MyPanel myPanel=null;
    public static void main(String[] args) {
        new BallMove();
    }
    public BallMove(){
        myPanel=new MyPanel();
        this.add(myPanel);
        this.setSize(400,500);
        this.setVisible(true);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel implements KeyListener {
    private int x,y;
    public MyPanel(){
        x=10;
        y=10;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x,y,30,30);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A){
            x-=2;
        }
        if(e.getKeyCode()==KeyEvent.VK_D){
            x+=2;
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            y-=2;
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            y+=2;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
