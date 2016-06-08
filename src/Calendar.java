/**
 * Created by EMGo on 6/8/2016.
 */
import java.util.Scanner;
import java.net.URL;
import java.io.IOException;
public class Calendar {
    try {

        URL url = new URL("https://googledrive.com/host/0B3JNWZriD7u5VTEyTXdlMU9tZzQ/rotation-calendar.ics");
        Scanner scan = new Scanner(url.openStream());
        while(scan.hasNext()){
            scan.nextLine();
        }

    } catch (IOException ex){
        ex.printStackTrace();
    }

}
