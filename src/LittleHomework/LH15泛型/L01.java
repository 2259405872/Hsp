package LittleHomework.LH15泛型;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class L01 {
    public static void main(String[] args) {
        ArrayList<Empoyee> empoyees = new ArrayList<Empoyee>();
        Empoyee empoyee1 = new Empoyee("杨山", 120, new MyDate(2003, 7, 17));
        Empoyee empoyee2 = new Empoyee("罗阳", 130, new MyDate(2002, 7, 17));
        Empoyee empoyee3 = new Empoyee("向进", 140, new MyDate(2003, 4, 17));
        Empoyee empoyee4 = new Empoyee("魏玉鑫", 150, new MyDate(2003, 12, 17));
        empoyees.add(empoyee1);
        empoyees.add(empoyee2);
        empoyees.add(empoyee3);
        empoyees.add(empoyee4);

        empoyees.sort(new Comparator<Empoyee>(){

            @Override
            public int compare(Empoyee o1, Empoyee o2) {
                if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1.getSal()!=o2.getSal()) {
                    return (int)(o1.getSal()-o2.getSal());
                } else if (!o1.getBirthday().equals(o2.getBirthday())) {
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }
                return 0;
            }
        });
    }
}

class Empoyee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Empoyee() {
    }

    public Empoyee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Empoyee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int year;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        if (o.getYear() != getYear()) {
            return o.getYear()-getYear();
        } else if (o.getMonth()!=getMonth()) {
            return o.getMonth()-getMonth();
        } else if (o.getDay()!=getDay()) {
            return o.getDay()-getDay();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return month == myDate.month && year == myDate.year && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year, day);
    }
}
