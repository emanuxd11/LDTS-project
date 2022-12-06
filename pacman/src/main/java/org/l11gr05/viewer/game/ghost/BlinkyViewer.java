package org.l11gr05.viewer.game.ghost;

import org.l11gr05.elements.ghost.Blinky;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.game.IElementViewer;

public class BlinkyViewer implements IElementViewer<Blinky> {
    @Override
    public void draw(Blinky blinky, GUI gui) {
        gui.drawBlinky(blinky.getPosition());
    }
}
