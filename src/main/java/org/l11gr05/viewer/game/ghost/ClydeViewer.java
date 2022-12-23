package org.l11gr05.viewer.game.ghost;

import org.l11gr05.model.elements.ghost.Clyde;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.game.IElementViewer;

public class ClydeViewer implements IElementViewer<Clyde> {
    @Override
    public void draw(Clyde clyde, GUI gui) {
        gui.drawClyde(clyde);
    }
}
