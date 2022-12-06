package org.l11gr05;

import org.l11gr05.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game();
    }

    private void start() throws IOException {

    }
}
