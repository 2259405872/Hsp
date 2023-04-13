package Homework.H14集合;

import java.util.ArrayList;

public class H01 {
    public static void main(String[] args) {
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("新冠确诊病例超千万，数百万印度信众赴恒河XXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
        news.add(new News("捞起一看，赶快放生XXXXXXXXXXXXXXXXXXXXXXXXXX"));

        for (int i = news.size()-1; i >=0 ; i--) {
            String str = news.get(i).getTittle();
            if (str.length()>15) {
                StringBuilder sb = new StringBuilder(str);
                sb.delete(15, sb.length());
                sb.append("...");
                str=sb.toString();
            }
            System.out.println(str);
        }
    }
}
class News{
    private String tittle;
    private String content;

    public News(String tittle) {
        this.tittle = tittle;
    }

    public News() {
    }

    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "tittle='" + tittle;
    }
}