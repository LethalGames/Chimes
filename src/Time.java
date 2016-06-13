/**
 * Created by IMRegan on 6/10/2016.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;


public class Time {
    public static double getTime(){
        LocalTime time = LocalTime.now();
        return ((double)time.getSecond()/10000) + ((double)time.getMinute()/100) + time.getHour();
    }
    public static String getDate(){
        LocalDate date = LocalDate.now();
        String str = "" + (date.getYear()*10000 + date.getMonthValue()*100 + date.getDayOfMonth());
        return str;
    }
}
