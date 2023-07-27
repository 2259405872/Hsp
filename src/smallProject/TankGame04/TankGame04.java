package smallProject.TankGame04;

import javax.swing.*;

class TankGame04 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        Thread t=new Thread(mp);
        t.start();
        this.add(mp);
        this.setSize(1000, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
    }

}
