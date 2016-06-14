import java.util.ArrayList;

public class Chimes {
    private int[][] days = new int[][]{new int[]{0, 1, 2, 3, 4}, new int[]{5, 6, 0, 1, 2}, new int[]{3, 4, 5, 6, 0}, new int[]{1, 2, 3, 4, 5}, new int[]{6, 0, 1, 2, 3}, new int[]{4, 5, 6, 0, 1}, new int[]{2, 3, 4, 5, 6}};
    private double[] startTimes = new double[]{7.25, 8.40, 9.49, 10.58, 12.54}, endTimes = new double[]{8.30, 9.45, 10.54, 12.50, 13.55}, altStartTimes = new double[]{7.25, 8.30, 9.24, 10.04, 10.58, 12.54}, altEndTimes = new double[]{8.15, 9.20, 10.00, 10.54, 12.50, 13.55};
    private boolean isAlt;
    private int currentDay;
    private String summary;
    private ArrayList<Integer>[] alarmTimes = new ArrayList[7];
    public void Chimes() {
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
    }
    public void putThisInPaintLoopOnceThereIsAGUI(){
        for(int i = 0; i < getAlarmTimes(getCurrentPeriod(), getCurrentBlock()).length; i++){
            System.out.println(((double)(int)((Time.getTime())*100))/100 + " : " + ((double)(int)((getAlarmTimes(getCurrentPeriod(), getCurrentBlock())[i])*100))/100);
            if(((double)(int)((Time.getTime())*100))/100 == ((double)(int)((getAlarmTimes(getCurrentPeriod(), getCurrentBlock())[i])*100))/100) {
                Sound.playSound("chime.wav");
            }
        }
    }
    private int getCurrentBlock(){
        for(int i = 0; i < startTimes.length; i++){
            if(Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]){
                return i;
            }
        }
        return -1;
    }
    private int getCurrentPeriod(){
        for(int i = 0; i < startTimes.length; i++){
            if(Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]){
                return days[currentDay][i];
            }
        }
        System.out.println("No period found");
        return -1;
    }
    private double[] getAlarmTimes(int period, int block){
        double[] alarms = new double[alarmTimes[period].size()];
        for(int i = 0; i < alarms.length; i++){
            alarms[i] = endTimes[block] - (double)alarmTimes[period].get(i)/100;
            while(alarms[i] % 1 > .59){
                alarms[i] += .4;
            }
        }
        return alarms;
    }
}
