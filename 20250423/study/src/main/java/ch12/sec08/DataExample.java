package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataExample {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String date = sdf.format(now);
        System.out.println(date);
    }
}
