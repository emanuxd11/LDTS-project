package org.l11gr05.viewer.game.ghost;

import org.l11gr05.classes.game.elements.ghost.Pinky;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.game.IElementViewer;

public class PinkyViewer implements IElementViewer<Pinky> {
    @Override
    public void draw(Pinky pinky, GUI gui) {
        gui.drawPinky(pinky.getPosition());
    }
}
