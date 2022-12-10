package org.l11gr05;

import org.l11gr05.gui.LanternaGUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.states.MenuState;
import org.l11gr05.states.State;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(28, 32);
        this.state = new MenuState(new Menu());
    }

    public void setState(State state){
        this.state = state;
    }

    // just testing this out
    public static void playSound(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(filePath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        clip.start();

        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException {
        playSound("/home/manu/Progs/LDTS_2022/project-l11gr05/pacman/src/main/resources/audio/startUp.wav");
        new Game().start();
    }

    private void start() throws IOException{
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while(this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
        }

        gui.close();
    }
}
