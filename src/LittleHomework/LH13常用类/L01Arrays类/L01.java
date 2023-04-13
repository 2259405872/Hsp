package LittleHomework.LH13常用类.L01Arrays类;

import java.util.Comparator;

public class L01 {

}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public class CP_Price_DR implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o1.price-o2.price);
        }
    }

    public class CP_Price_R implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o2.price-o1.price);
        }
    }

    public class CP_Name_DR implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return (int)(o1.name.length()-o2.name.length());
        }
    }


}