import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class Sound {
    public static void playSound(final String input)
    {
        new Thread(() ->
        {
            try
            {
                Clip c = AudioSystem.getClip();
                File sound = new File("P:\\" + input);
                AudioInputStream ain = AudioSystem.getAudioInputStream(sound);
                c.open(ain);
                c.start();
            }
            catch (LineUnavailableException | UnsupportedAudioFileException | IOException e)
            {
                e.printStackTrace();
            }
        }).start();
    }
}
// Comment by Mr. Anderson
// Comment by Eli Go