import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class Sound {
    public void playSound(final String input)
    {
        new Thread(() ->
        {
            try
            {
                Clip c = AudioSystem.getClip();
                File sound = new File("C:\\Users\\Derek\\IdeaProjects\\Player\\out\\artifacts\\Player_jar\\sounds\\" + input);
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