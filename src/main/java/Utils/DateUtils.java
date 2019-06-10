package Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// In progress
public class DateUtils {
    /**
     * This class will return a date of today, tomorow or one week from today based on your preference
     * @param format Here you can state which format you want for your date; Some of the acceptable formats are as follows:
     *               dd-MM-YYYY, YYYY-MM-dd, MM-dd-YYYY, YYYY-dd-MM, MM-dd, dd-MM
     */
    public static String returnTheDate(period period, String format){
        String date;
        switch (period){
            case TODAY:
                date=getTodaysDate();
                break;
            case TOMOROW:
                date=getTomorrowsDate();
                break;
            case WEEK:
                date=getOneWeekFromToday();
                break;
            default:
                date=getTodaysDate();
                break;
        }
        return ofFormat(date, format);
    }
    public static String getTodaysDate(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return date;
    }
    public static String getTomorrowsDate(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return LocalDate.parse(date).plusDays(1).toString();
    }
    public static String getOneWeekFromToday(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return LocalDate.parse(date).plusDays(7).toString();
    }
    public static String ofFormat(String date, String format){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).toString();
    }
    public enum period{TODAY, TOMOROW, WEEK;}
}
