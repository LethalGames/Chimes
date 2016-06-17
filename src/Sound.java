import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
class Sound {
    static void playSound(final String input)
    {
        new Thread(() ->
        {
            try
            {
                Clip c = AudioSystem.getClip();
                System.out.println("ding");
                File sound = new File("C:\\Users\\PAnderson\\Google Drive\\Classes\\General\\Software\\Chimes\\Sounds\\" + input);
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
/*
Comment by Mr. Anderson
Comment by Eli Go test
*/
