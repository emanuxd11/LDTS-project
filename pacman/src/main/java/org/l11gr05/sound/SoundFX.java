package org.l11gr05.sound;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundFX {
    private final String effect;
    private final Clip clip;
    private final AudioInputStream audioStream;
    public SoundFX(String effect) {
        this.effect = effect;
        File file = new File(getResourcePath());
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private String getResourcePath() {
        return System.getProperty("user.dir") + "/src/main/resources/audio/" + effect;
    }

    public void play() {
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }

    public void stop() {
        clip.close();
    }
}
