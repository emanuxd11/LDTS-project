package org.l11gr05.sound;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public abstract class SoundFX {
    private String filePath;
    public SoundFX() {
        
    }

    // deve tocar
    public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("/home/manu/Programas/LDTS_2022/project-l11gr05/pacman/src/main/resources/audio/startUp.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
