package Utils;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
    public static String returnTheDate(period period){
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
        return date;
    }
    public static LocalDate getTodaysDate(){
        //String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return LocalDate.now();
    }
    public static String getTomorrowsDate(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        return LocalDate.parse(date).plusDays(1).toString();
    }
    public static String getOneWeekFromToday(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        return cal.getTime().toString();
    }
    public static String ofFormat(String format, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.toString();
    }
    public enum period{TODAY, TOMOROW, WEEK;}

   /* public static String getCustomDate(int daysFromToday, String format){

    }*/
    public static void main(String[] args){
        System.out.println(returnTheDate(period.TODAY, "dd/MM/uuuu"));
    }
}
