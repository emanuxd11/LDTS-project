package org.l11gr05.viewer.game;

import org.l11gr05.model.elements.Pacman;
import org.l11gr05.gui.GUI;

public class PacmanViewer implements IElementViewer<Pacman> {

    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman);
    }
}
