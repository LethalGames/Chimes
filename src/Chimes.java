import java.util.ArrayList;

class Chimes {
    private int[][] days = new int[][]{new int[]{0, 1, 2, 3, 4}, new int[]{5, 6, 0, 1, 2}, new int[]{3, 4, 5, 6, 0}, new int[]{1, 2, 3, 4, 5}, new int[]{6, 0, 1, 2, 3}, new int[]{4, 5, 6, 0, 1}, new int[]{2, 3, 4, 5, 6}};
    private double[] startTimes = new double[]{7.25, 8.40, 9.49, 10.58, 12.54}, endTimes = new double[]{8.30, 9.45, 10.54, 12.50, 13.55}, altStartTimes = new double[]{7.25, 8.30, 10.04, 10.58, 12.54}, altEndTimes = new double[]{8.15, 9.20, 10.54, 12.50, 13.55};
    private boolean isAlt;
    private int currentDay;
    private ArrayList[] alarmTimes = new ArrayList[7];
    private static boolean run = true;
    private int playable;
    Chimes() {
        Calendar calendar = new Calendar();
        System.out.println(Time.getDate());
        String summary = calendar.getTodaysScedual(Time.getDate());
        System.out.println(summary);
        if(summary.contains("alt")){
            isAlt = true;
        }
        currentDay = (int) summary.toCharArray()[0] - 65;
        System.out.println(currentDay);//so you can use days[currentDay][<block>] to get the schedule for the day
        System.out.println(Time.getTime() + " ; " + Time.getDate());
        for(int i = 0; i < alarmTimes.length; i++){
            alarmTimes[i] = new ArrayList<Integer>();
        }
    }
    void putThisInPaintLoopOnceThereIsAGUI(){
        if(!alarmTimes[getCurrentPeriod()].isEmpty())
            for(int i = 0; i < getAlarmTimes(getCurrentPeriod(), getCurrentBlock()).length; i++){
                if(playable != 0 && playable < (int)(Time.getTime()*100))
                    playable = 0;
                if(((double)(int)((Time.getTime())*100))/100 == ((double)(int)((getAlarmTimes(getCurrentPeriod(), getCurrentBlock())[i])*100))/100) {
                    if(playable == 0) {
                        Sound.playSound("chime.wav");
                        playable = (int)(Time.getTime()*100);
                    }
                }
            }
    }
     private int getCurrentBlock(){
        if(isAlt) {
            for (int i = 0; i < altStartTimes.length; i++) {
                if (Time.getTime() > altStartTimes[i] && Time.getTime() < altEndTimes[i]) {
                    return i;
                }
            }
        }
        else
            for(int i = 0; i < startTimes.length; i++){
                if(Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]){
                    return i;
                }
            }
        return -1;
    }
   private int getCurrentPeriod(){
        if(isAlt) {
            for (int i = 0; i < altStartTimes.length; i++) {
                if (Time.getTime() > altStartTimes[i] && Time.getTime() < altEndTimes[i]) {
                    return days[currentDay][i];
                }
            }
        }
        else
            for (int i = 0; i < startTimes.length; i++) {
                if (Time.getTime() > startTimes[i] && Time.getTime() < endTimes[i]) {
                    return days[currentDay][i];
                }
            }
        System.out.println("No period found");
        return -1;
    }
     private double[] getAlarmTimes(int period, int block){
        double[] alarms = new double[alarmTimes[period].size()];
        for(int i = 0; i < alarms.length; i++){
            if(isAlt) {
                alarms[i] = altEndTimes[block] - Double.parseDouble(alarmTimes[period].get(i) + "") / 100;
            }
            else
                alarms[i] = endTimes[block] - Double.parseDouble(alarmTimes[period].get(i) + "") / 100;
            while(alarms[i] % 1 > .59){
                alarms[i] += .4;
            }
        }
        return alarms;
    }
    public String[] getAlarms(){
        int counter = 0;
        for(int i = 0; i < alarmTimes.length; i++){
            for(int l = 0; l < alarmTimes[i].size(); l++){
                ++counter;
            }
        }
        String[] alarmStrings = new String[counter];
        counter = 0;
        for(int i = 0; i < alarmTimes.length; i++) {
            for (int l = 0; l < alarmTimes[i].size(); l++) {
                alarmStrings[counter] = "" + alarmTimes[i].get(l);
            }
        }
        return alarmStrings;
    }
    static void stop(){run = false;}
    boolean isRunning(){return run;}
    void addAlarm(int period, int timeFromEnd){
        alarmTimes[period].add(timeFromEnd);
        for(int i = 0; i < 7; i++){
            System.out.println("-^-" + i + "-^-");
            for(int l = 0; l < alarmTimes[i].size(); l++)
                System.out.println(" - " + alarmTimes[i].get(l) + " - ");
        }
    }
}
class ChimeLoop extends Thread{
    private Chimes c;
    ChimeLoop(Chimes c){
        this.c = c;
    }
    public void run(){
        while(c.isRunning()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.putThisInPaintLoopOnceThereIsAGUI();
        }
    }
}

