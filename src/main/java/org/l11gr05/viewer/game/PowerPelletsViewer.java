package org.l11gr05.viewer.game;

import org.l11gr05.model.elements.PowerPellet;
import org.l11gr05.gui.GUI;

public class PowerPelletsViewer implements IElementViewer<PowerPellet> {
    @Override
    public void draw(PowerPellet powerPellet, GUI gui) {
        gui.drawPowerPellet(powerPellet.getPosition());
    }
}
