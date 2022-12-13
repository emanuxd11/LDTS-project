package org.l11gr05.sound;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundFX {
    private final String effect;
    private final Clip clip;
    private final AudioInputStream audioStream;
    private static String prev = "wa";
    private static SoundFX startUp;
    private static SoundFX wa;
    private static SoundFX ka;
    private static SoundFX powerUp;
    private static SoundFX pacmanEatsGhost;
    private static SoundFX ghostSiren1;
    private static SoundFX pacmanDies;
    private static SoundFX menuTheme;

    private String getResourcePath() {
        return System.getProperty("user.dir") + "/src/main/resources/audio/" + effect;
    }

    private SoundFX(String effect) {
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

    public static void initAllSounds() {
        startUp = new SoundFX("startUp.wav");
        wa = new SoundFX("wa.wav");
        ka = new SoundFX("ka.wav");
        ghostSiren1 = new SoundFX("ghostSiren.wav");
        pacmanEatsGhost = new SoundFX("pacmanEatsGhost.wav");
        powerUp = new SoundFX("powerUp.wav");
        menuTheme = new SoundFX("menuTheme2.wav");
        pacmanDies = new SoundFX("pacmanDies.wav");
    }

    public boolean isPlaying() {
        return clip.isActive();
    }

    public void play() {
        try {
            if(!clip.isOpen())
                clip.open(audioStream);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }

    public void loop() {
        try {
            if (!clip.isOpen()) {
                clip.open(audioStream);
            }
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.setMicrosecondPosition(0);
    }

    public static SoundFX getPrevEatSound() {
        if (prev.equals("wa")) {
            return ka;
        } else {
            return wa;
        }
    }

    public static SoundFX getEatSound() {
        if (prev.equals("wa")) {
            prev = "ka";
            return wa;
        } else {
            prev = "wa";
            return ka;
        }
    }

    public static void stopGameSounds() {
        startUp.stop();
        powerUp.stop();
        ghostSiren1.stop();
        wa.stop();
        ka.stop();
        pacmanEatsGhost.stop();
    }

    public static void gamePause(int num){
        try {
            Thread.sleep(num);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void stopMenuSounds() {
        menuTheme.stop();
    }

    public static SoundFX getStartUp() {
        return startUp;
    }

    public static SoundFX getPowerUp() {
        return powerUp;
    }

    public static SoundFX getGhostSiren1() {
        return ghostSiren1;
    }

    public static SoundFX getPacmanEatsGhost() {
        return pacmanEatsGhost;
    }

    public static SoundFX getMenuTheme() {
        return menuTheme;
    }

    public static SoundFX getPacmanDies() {
        return pacmanDies;
    }
}
