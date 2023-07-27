package Homework.H17线程;

import java.util.Random;
import java.util.Scanner;

public class H01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread{

    private boolean loop=true;
    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() *100+1));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{
    private A a;
    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            Scanner input = new Scanner(System.in);
            char key =input.next().toUpperCase().charAt(0);
            if (key == 'Q'){
                a.setLoop(false);
                break;
            }
        }
    }
}