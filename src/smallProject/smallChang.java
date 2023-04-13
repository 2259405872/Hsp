package smallProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class smallChang {
    private double account=0;
    private ArrayList<String> history=new ArrayList<>();

    public smallChang() {
        start();
    }

    public smallChang(double account) {
        this();
        this.account = account;
    }

    public void start(){
        boolean b=true;
        do{
            System.out.println("-------------------------零钱通菜单-----------------------");
            System.out.println("                       1.零钱通明细                       ");
            System.out.println("                       2.收益入账                         ");
            System.out.println("                       3.消费                         ");
            System.out.println("                       4.退   出                         ");
            System.out.println("请选择（1-4）");

            Scanner input=new Scanner(System.in);
            int choose= input.nextInt();

            switch (choose){
                case 1:
                    System.out.println("1.零钱通明细");
                    printHistory();
                    break;
                case 2:
                    System.out.println("2.收益入账 ");
                    System.out.print("请输入存款金额:");
                    double sum= input.nextDouble();
                    System.out.println();
                    deposit(sum);
                    break;
                case 3:
                    System.out.println("3.消费   ");
                    System.out.print("请消费金额和地点:");
                    double money= input.nextDouble();
                    String place= input.next();
                    System.out.println();
                    cost(money,place);
                    break;
                case 4:
                    System.out.println("4.退   出");
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while(b);
        System.out.println("退出了零钱通");
    }

    private void printHistory(){
        System.out.println("-------------------------零钱通明细-----------------------");
        for (String str: history) {
            System.out.println(str);
        }
    }
    private void deposit(double sum){
        account+=sum;
        System.out.println("已存入"+sum+"元");
        history.add("收益入账:"+sum+"  "+ Calendar.getInstance().toString()+"   余额:"+account);
    }

    private void cost(double money,String place){
        if (account>=money) {
            account -= money;
            System.out.println(place+"消费" + money + "元");
            history.add(place+"消费:"+money+" "+ Calendar.getInstance().toString()+"   余额:"+account);
        }else {
            System.out.println("余额不足");
        }
    }

}
