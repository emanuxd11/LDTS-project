package org.l11gr05;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final Screen screen;

    /* isto é só para testar, roubei ao restivo lmao */
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public Game() throws FontFormatException, IOException, URISyntaxException {
        int height = 20;
        int width = 20;
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game();
    }

    private void start() throws IOException {

    }
}
