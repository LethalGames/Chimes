/**
 * Created by EMGo on 6/8/2016.
 */
import java.util.Scanner;
import java.net.URL;
import java.io.IOException;
class Calendar {
    private int numLines;
    Calendar(){
        createScanner("https://googledrive.com/host/0B3JNWZriD7u5VTEyTXdlMU9tZzQ/rotation-calendar.ics");
    }
    private void createScanner(String url) {
        try {
            Scanner scan = new Scanner(new URL(url).openStream());
            while (scan.hasNext()) {
                scan.nextLine();
                ++numLines;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
