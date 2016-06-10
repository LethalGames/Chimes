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
        try {
            scan = new Scanner(new URL(url).openStream());
            while (scan.hasNext()) {
                    scan.nextLine();
                ++numLines;
            }
            scan = new Scanner(new URL(url).openStream());
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
                        if(currentLine.startsWith("SUMMARY:")){
                            return currentLine.substring(8);
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
