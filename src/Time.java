/**
 * Created by IMRegan on 6/10/2016.
 */
import java.time.LocalTime;

public class Time {
    public double getTime(){
        LocalTime time = LocalTime.now();
        return (time.getSecond()/100) + (double)(time.getMinute());
    }
}
