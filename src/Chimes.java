import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Chimes {
    int[][] days = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 1, 2, 3}, new int[]{4, 5, 6, 7, 1}, new int[]{2, 3, 4, 5, 6}, new int[]{7, 1, 2, 3, 4}, new int[]{5, 6, 7, 1, 2}, new int[]{3, 4, 5, 6, 7}};
    double[] startTimes = new double[]{7.25, 8.40, 9.49, 10.58, 12.54};
    double[] endTimes = new double[]{8.30, 9.45, 10.54, 12.50, 13.55};
    double[] altStartTimes = new double[]{7.25, 8.30, 9.24, 10.04, 10.58, 12.54};
    double[] altEndTimes = new double[]{8.15, 9.20, 10.00, 10.54, 12.50, 13.55};
    boolean isAlt;
    public static void main(String[] args) throws InterruptedException {
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        Thread.sleep(500);
        Sound.playSound("chime.wav");
        //Ilona Comment


        LocalTime time = LocalTime.now();
        double currentTime = time.getHour() + (time.getMinute()/100);
    }
}
