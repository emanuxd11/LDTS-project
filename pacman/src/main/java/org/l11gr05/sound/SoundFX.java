package org.l11gr05.sound;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

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

    /* ? */
    public static void gamePause(int num){
        try {
            Thread.sleep(num);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void initSounds() {
        startUp = new SoundFX("startUp.wav");
        wa = new SoundFX("wa.wav");
        ka = new SoundFX("ka.wav");
        ghostSiren1 = new SoundFX("ghostSiren.wav");
        pacmanEatsGhost = new SoundFX("pacmanEatsGhost.wav");
        powerUp = new SoundFX("powerUp.wav");
        menuTheme = new SoundFX("menuTheme2.wav");
        pacmanDies = new SoundFX("pacmanDies.wav");
    }

    private boolean isPlaying() {
        return clip.isActive();
    }

    private void play() {
        try {
            if(!clip.isOpen())
                clip.open(audioStream);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }

    private void loop() {
         try {
            if (!clip.isOpen()) {
                clip.open(audioStream);
            }
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private void stop() {
         try {
            clip.stop();
            clip.setMicrosecondPosition(0);
        } catch(NullPointerException e){}
    }

    public static void stopGameSounds() {
        try {
            stopStartUp();
            stopPowerUp();
            stopGhostSiren1();
            stopWa();
            stopKa();
            stopPacmanEatsGhost();
        } catch (NullPointerException e){}
    }

    public static void loopMenuTheme() {
        menuTheme.loop();
    }

    public static void stopMenuSounds() {
        try {
            stopMenuTheme();
        }catch(NullPointerException e){}
    }

    public static void playStartUp() {
        try {
            startUp.play();
        }catch(NullPointerException e){}
    }

    public static void stopStartUp() {
        try {
            startUp.stop();
        } catch (NullPointerException e){}
    }

    private static void playWa() {
        try {
            wa.play();
        } catch(NullPointerException e){}
    }

    private static void stopWa() {
        wa.stop();
    }

    private static void playKa() {
        ka.play();
    }

    private static void stopKa() {
        ka.stop();
    }

    public static void playPowerUp() {
        try {
            powerUp.stop();
            powerUp.play();
        } catch(NullPointerException e){}
    }

    public static void stopPowerUp() {
        powerUp.stop();
    }

    public static void playPacmanEatsGhost() {
        try {
            pacmanEatsGhost.stop();
            pacmanEatsGhost.play();
        } catch(NullPointerException e){}
    }

    public static void stopPacmanEatsGhost() {
        pacmanEatsGhost.stop();
    }

    public static void loopGhostSiren1() {
        if (!powerUp.isPlaying()) {
            stopPowerUp();
            ghostSiren1.loop();
        }
    }

    public static void stopGhostSiren1() {
        ghostSiren1.stop();
    }

    public static void playPacmanDies() {
        try {
            pacmanDies.stop();
            pacmanDies.play();
        } catch(NullPointerException e){}
    }

    public static void stopPacmanDies() {
        pacmanDies.stop();
    }

    public static void stopMenuTheme() {
        menuTheme.stop();
    }

    public static void playEatSound() {
        try {
            if (prev.equals("ka")) {
                prev = "wa";
                stopKa();
                playWa();
            } else {
                prev = "ka";
                stopWa();
                playKa();
            }
        }catch(NullPointerException e){}
    }

    public static void powerPelletEatenSound(){
        try{
            SoundFX.playEatSound();
            SoundFX.stopGhostSiren1();
            SoundFX.playPowerUp();
        }catch(NullPointerException e){}
    }
}
