package org.l11gr05.states;

import org.l11gr05.menu.Menu;
import org.l11gr05.viewer.Viewer;
import org.l11gr05.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    public Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
}
