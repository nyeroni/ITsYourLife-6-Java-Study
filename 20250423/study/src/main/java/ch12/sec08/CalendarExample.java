package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        String strWeek = null;
        switch (week) {
            case Calendar.MONDAY :
                strWeek = "월요일";
                break;
            case Calendar.TUESDAY :
                strWeek = "화요일";
                break;
            case Calendar.WEDNESDAY :
                strWeek = "수요일";
                break;
            case Calendar.THURSDAY :
                strWeek = "목요일";
                break;
            case Calendar.FRIDAY :
                strWeek = "금요일";
                break;
            case Calendar.SATURDAY :
                strWeek = "토요일";
                break;
            default :
                strWeek = "일요일";
        }
        int amPm = calendar.get(Calendar.AM_PM);
        String strAmPm = "";
        if(amPm == Calendar.AM) {
            strAmPm = "오전";
        } else if(amPm == Calendar.PM) {
            strAmPm = "오후";
        }
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(year + "년 " + month + "월 " + day + "일");
        System.out.println(strWeek + " " + strAmPm);
        System.out.println(hour + "시 " + minute + "분 " + second + "초");
    }
}
