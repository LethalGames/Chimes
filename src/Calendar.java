import java.util.Scanner;
import java.net.URL;
import java.io.IOException;
class Calendar {
    private int numLines;
    private Scanner scan;
    Calendar(){
        createScanner("https://calendar.google.com/calendar/ical/nps.org_7iedrkgs2rbf6prfqr9r1m5ov4%40group.calendar.google.com/public/basic.ics");
    }
    private void createScanner(String url) {
        int num = 20;
        try {
            scan = new Scanner(new URL(url).openStream());
            while (scan.hasNext()) {
                if(numLines == num) {
                    scan.nextLine();    //Only scans the "SUMMARY" line//
                    num += 14;
                }
                ++numLines;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getTodaysScedual(String yearMonthDay){
        while(scan.hasNext()) {
            String currentLine = scan.nextLine();
            if (currentLine.startsWith("DTEND;VALUE=DATE:")) {
                currentLine = currentLine.substring(17);
                if (currentLine.equals(yearMonthDay)) {
                    while (!currentLine.startsWith("DTSTART;VALUE=DATE:")) {
                        currentLine = scan.nextLine();
                        if(currentLine.startsWith("Summary")){
                            return currentLine.substring(9);
                        }
                    }
                    System.out.println("Summary not found");
                    return "";
                }
            }
        }
        System.out.println("Date not found");
        return "";
    }
}
