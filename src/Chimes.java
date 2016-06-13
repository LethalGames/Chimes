
public class Chimes {
    static int[][] days = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 1, 2, 3}, new int[]{4, 5, 6, 7, 1}, new int[]{2, 3, 4, 5, 6}, new int[]{7, 1, 2, 3, 4}, new int[]{5, 6, 7, 1, 2}, new int[]{3, 4, 5, 6, 7}};
    static double[] startTimes = new double[]{7.25, 8.40, 9.49, 10.58, 12.54}, endTimes = new double[]{8.30, 9.45, 10.54, 12.50, 1.55}, altStartTimes = new double[]{7.25, 8.30, 9.24, 10.04, 10.58, 12.54}, altEndTimes = new double[]{8.15, 9.20, 10.00, 10.54, 12.50, 1.55};
    static boolean isAlt;
    static int currentDay;
    static String summary;
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        summary = calendar.getTodaysScedual(2016 * 10000 + 6 * 100 + 10 + "");
        System.out.println(summary);
        if(summary.contains("alt")){
            isAlt = true;
        }
        currentDay = (int)summary.toCharArray()[0] - 64;
        System.out.println(currentDay);//so you can use days[currentDay][<block>] to get the schedule for the day
        System.out.println(Time.getTime() + " ; " + Time.getDate());
    }
}
