package org.l11gr05.gui;

import org.l11gr05.elements.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPacman(Position position);

    void drawWall(Position position);

    void drawPacDot(Position position);

    void drawPowerPellet(Position position);

    void drawBlinky(Position position);

    void drawPinky(Position position);

    void drawInky(Position position);

    void drawClyde(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}