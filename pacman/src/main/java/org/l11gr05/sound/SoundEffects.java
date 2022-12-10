package org.l11gr05.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffects {
    private Clip clip;
    private AudioInputStream audioInputStream;

    public SoundEffects(String fileName) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        String filePath = new File(System.getProperty("user.dir")).getPath() +
                "/src/main/resources/audio/";
        filePath += fileName;

        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.start();
    }
}
