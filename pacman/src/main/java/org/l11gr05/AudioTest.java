package org.l11gr05;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AudioTest {
    // deve tocar
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("/home/manu/Programas/LDTS_2022/project-l11gr05/pacman/src/main/resources/audio/startUp.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
    }
}
