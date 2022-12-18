package org.l11gr05;

import org.l11gr05.gui.LanternaGUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.sound.SoundFX;
import org.l11gr05.states.MenuState;
import org.l11gr05.states.State;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        SoundFX.initSounds();
        this.gui = new LanternaGUI(28, 32);
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException {
        new Game().start();
    }

    private void start() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while(this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {}
        }

        gui.close();
    }
}
