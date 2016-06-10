import java.util.Scanner;
import java.net.URL;
import java.io.IOException;
class Calendar {
    private int numLines;
    Calendar(){
        createScanner("https://googledrive.com/host/0B3JNWZriD7u5VTEyTXdlMU9tZzQ/rotation-calendar.ics");
    }
    private void createScanner(String url) {
        int num = 20;
        try {
            Scanner scan = new Scanner(new URL(url).openStream());
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
}
