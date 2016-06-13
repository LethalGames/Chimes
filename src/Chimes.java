import java.util.ArrayList;

public class Chimes {
    private static int[][] days = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 1, 2, 3}, new int[]{4, 5, 6, 7, 1}, new int[]{2, 3, 4, 5, 6}, new int[]{7, 1, 2, 3, 4}, new int[]{5, 6, 7, 1, 2}, new int[]{3, 4, 5, 6, 7}};
    private static double[] startTimes = new double[]{7.25, 8.40, 9.49, 10.58, 12.54}, endTimes = new double[]{8.30, 9.45, 10.54, 12.50, 1.55}, altStartTimes = new double[]{7.25, 8.30, 9.24, 10.04, 10.58, 12.54}, altEndTimes = new double[]{8.15, 9.20, 10.00, 10.54, 12.50, 1.55};
    private static boolean isAlt;
    private static int currentDay;
    private static String summary;
    private static ArrayList<Integer>[] alarmTimes = new ArrayList[7];
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        System.out.println(Time.getDate());
        summary = calendar.getTodaysScedual(Time.getDate() + "");
        System.out.println(summary);
        if(summary.contains("alt")){
            isAlt = true;
        }
        currentDay = (int)summary.toCharArray()[0] - 65;
        System.out.println(currentDay);//so you can use days[currentDay][<block>] to get the schedule for the day
        System.out.println(Time.getTime() + " ; " + Time.getDate());
        for(int i = 0; i < alarmTimes.length; i++){
            alarmTimes[i] = new ArrayList<>();
        }


        //Random Times
        alarmTimes[5].add(40);


        putThisInPaintLoopOnceThereIsAGUI();
    }
    private static void putThisInPaintLoopOnceThereIsAGUI(){
        getAlarmTimes(getCurrentPeriod(), getCurrentBlock());
    }
    private static int getCurrentBlock(){
        for(int i = 0; i < startTimes.length; i++){
            if(Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]){
                return i;
            }
        }
        return -1;
    }
    private static int getCurrentPeriod(){
        for(int i = 0; i < startTimes.length; i++){
            if(Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]){
                return days[currentDay][i];
            }
        }
        return -1;
    }
    private static double[] getAlarmTimes(int period, int block){
        double[] alarms = new double[alarmTimes[period].size()];
        for(int i = 0; i < alarms.length; i++){
            alarms[i] = startTimes[block] + alarmTimes[period].get(i);
        }
        return alarms;
    }
}
