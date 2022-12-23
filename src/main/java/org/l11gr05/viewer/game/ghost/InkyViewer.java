package org.l11gr05.viewer.game.ghost;

import org.l11gr05.model.elements.ghost.Inky;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.game.IElementViewer;

public class InkyViewer implements IElementViewer<Inky> {

    @Override
    public void draw(Inky inky, GUI gui) {
        gui.drawInky(inky);
    }
}
