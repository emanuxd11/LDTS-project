package org.l11gr05.viewer.game;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.Viewer;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        // testing
        Pacman pacman = new Pacman();
        PacmanViewer pacmanViewer = new PacmanViewer();
        pacmanViewer.draw(pacman, gui);
    }
}
