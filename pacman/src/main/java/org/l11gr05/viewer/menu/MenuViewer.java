package org.l11gr05.viewer.menu;

import org.l11gr05.elements.Position;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu model) {
        super(model);
    }

    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");
    }
}
