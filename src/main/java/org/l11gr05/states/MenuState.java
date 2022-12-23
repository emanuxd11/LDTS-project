package org.l11gr05.states;

import org.l11gr05.controller.Controller;
import org.l11gr05.controller.menu.MenuController;
import org.l11gr05.menu.Menu;
import org.l11gr05.viewer.Viewer;
import org.l11gr05.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    public Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
}
