package Homework.H02异常与异常处理;

import java.util.Scanner;

public class H01 {
    public static void main(String[] args) {
        try {
            if (args.length!=2) {
                throw new ArrayIndexOutOfBoundsException("参数必须为两个");
            }

            int a=Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);

            double res=cal(a,b);
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("参数格式需要输入整数");
        }catch (ArithmeticException e){
            System.out.println("除数不能为零");
        }
    }
    public static double cal(int a,int b){
        return (double) a/b;
    }
}
