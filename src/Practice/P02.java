package Practice;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class P02 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i<10;i++){
            strings.add("hello"+i);
        }

//        for (String s : strings) {
//            System.out.println(s);
//            strings.remove(s);
//        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
            strings.remove(i);
            i--;
        }
    }
}
