package org.l11gr05.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.Blinky;
import org.l11gr05.classes.game.elements.ghost.Clyde;
import org.l11gr05.classes.game.elements.ghost.Inky;
import org.l11gr05.classes.game.elements.ghost.Pinky;
import org.l11gr05.classes.game.elements.ghost.ghostStates.ChasedState;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        TextGraphics graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#111111"));
        graphics.fillRectangle(new TerminalPosition(1, 1), new TerminalSize(width, height), ' ');
        //floorColor("#FFFFFF", width, height);
    }

    private void floorColor(String color, int width, int height){
        TextGraphics graphics = this.screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(1, 1), new TerminalSize(width, height), ' ');
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        //tg.putString(x, y + 1, ' ' + c);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPacman(Pacman pacman) {
        if(pacman.getDirection() == 'r') {
            drawCharacter(pacman.getPosition().getX(), pacman.getPosition().getY(), '<', "#FFD700");
        }
        else if (pacman.getDirection() == 'l'){
            drawCharacter(pacman.getPosition().getX(), pacman.getPosition().getY(), '>', "#FFD700");
        }
        else if (pacman.getDirection() == 'u'){
            drawCharacter(pacman.getPosition().getX(), pacman.getPosition().getY(), 'V', "#FFD700");
        }
        else{
            drawCharacter(pacman.getPosition().getX(), pacman.getPosition().getY(), '^', "#FFD700");
        }
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }

    @Override
    public void drawPacDot(Position position) {
        drawCharacter(position.getX(), position.getY(), '.', "#FFFFFF");
    }

    @Override
    public void drawPowerPellet(Position position) {
        drawCharacter(position.getX(), position.getY(), '*', "#FFFFFF");
    }

    @Override
    public void drawBlinky(Blinky blinky) {
        if(blinky.getState().getClass() == ChasedState.class){
            if (blinky.getState().getTimer() % 2 == 0 && blinky.getState().getTimer() > 30)
            drawCharacter(blinky.getPosition().getX(), blinky.getPosition().getY(), 'B', "#FFFFFF");
            else drawCharacter(blinky.getPosition().getX(), blinky.getPosition().getY(), 'B', "#5259E8");
        }
        else {
            drawCharacter(blinky.getPosition().getX(), blinky.getPosition().getY(), 'B', "#FF0000");
        }
    }

    @Override
    public void drawPinky(Pinky pinky) {
        if(pinky.getState().getClass() == ChasedState.class){
            if (pinky.getState().getTimer() % 2 == 0 && pinky.getState().getTimer() > 30)
            drawCharacter(pinky.getPosition().getX(), pinky.getPosition().getY(), 'P', "#FFFFFF");
            else drawCharacter(pinky.getPosition().getX(), pinky.getPosition().getY(), 'P', "#5259E8");
        }
        else {
            drawCharacter(pinky.getPosition().getX(), pinky.getPosition().getY(), 'P', "#FFB8FF");
        }
    }

    @Override
    public void drawInky(Inky inky) {
        if(inky.getState().getClass() == ChasedState.class){
            if (inky.getState().getTimer() % 2 == 0 && inky.getState().getTimer() > 30)
            drawCharacter(inky.getPosition().getX(), inky.getPosition().getY(), 'I', "#FFFFFF");
            else drawCharacter(inky.getPosition().getX(), inky.getPosition().getY(), 'I', "#5259E8");

        }
        else {
            drawCharacter(inky.getPosition().getX(), inky.getPosition().getY(), 'I', "#00FFFF");
        }
    }

    @Override
    public void drawClyde(Clyde clyde) {
        if(clyde.getState().getClass() == ChasedState.class){
            if (clyde.getState().getTimer() % 2 == 0 && clyde.getState().getTimer() >30)
            drawCharacter(clyde.getPosition().getX(), clyde.getPosition().getY(), 'C', "#FFFFFF");
            else
                drawCharacter(clyde.getPosition().getX(), clyde.getPosition().getY(), 'C', "#5259E8");
        }
        else {
            drawCharacter(clyde.getPosition().getX(), clyde.getPosition().getY(), 'C', "#FFB852");
        }
    }
    /* ****************************************************************************** */

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
