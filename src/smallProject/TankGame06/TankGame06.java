package smallProject.TankGame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

class TankGame06 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入1（开始新游戏）或者2（继续上局游戏）：");
        int key = input.nextInt();
        new TankGame06(key);
    }

    public TankGame06(int key) {
        mp = new MyPanel(key);
        Thread t=new Thread(mp);
        t.start();
        this.add(mp);
        this.setSize(1300, 770);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.keepRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
    }

}
