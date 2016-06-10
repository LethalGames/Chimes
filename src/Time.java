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
    public double getTime(){
        LocalTime time = LocalTime.now();
        return (time.getSecond()/100) + (double)(time.getMinute());
    }
    public int getMonth(){
        LocalDate date = LocalDate.now();
        return date.getMonthValue();
    }
    public int getDay(){
        LocalDate date = LocalDate.now();
        return date.getDayOfMonth();
    }
}
