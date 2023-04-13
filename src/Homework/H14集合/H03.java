package Homework.H14集合;

import java.util.HashMap;
import java.util.Set;

public class H03 {
    public static void main(String[] args) {
        HashMap<String, Integer> employees = new HashMap<>();

        employees.put("jack",650);
        employees.put("tom",1200);
        employees.put("smith",2900);

        employees.put("jack",2900);

        Set<String> keys = employees.keySet();

        for (String str:keys) {
            employees.put(str,employees.get(str)+100);
        }
    }
}
