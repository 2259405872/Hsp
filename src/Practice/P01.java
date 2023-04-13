package Practice;

public class P01 {
    public static void main(String[] args) {
        A a=new A();
        a1(a);
        System.out.println(a.a);
        String s="Ys";
        int[] ii=new int[10];
        int l=ii.length;
    }
    public static void a1(A a){
        a.change();
    }
}

class A{
    public int a=0;

    public void change(){
        a++;
    }
}
