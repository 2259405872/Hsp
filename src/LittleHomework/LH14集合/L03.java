package LittleHomework.LH14集合;

import java.util.HashMap;

public class L03 {
    public static void main(String[] args) {
        HashMap<String, Employee> employeeHashMap = new HashMap<String, Employee>();
        employeeHashMap.put("001",new Employee("罗阳",18888,new MyDate(2002,2,1)));
//        01通过keySet得foreach方式遍历
        for (String s:employeeHashMap.keySet()) {
            Employee employee = employeeHashMap.get(s);
            if (employee.getSalary()>18000) {
                System.out.println(employee);
            }
        }
//        02...

    }
}
