package org.l11gr05.controller.menu;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.ArenaFactory;
import org.l11gr05.controller.Controller;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                this.getModel().previousEntry();
                break;
            case DOWN:
                this.getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().exitSelected()) game.setState(null);
                if (getModel().startSelected()) game.setState(new GameState(new ArenaFactory().createArena("map.txt")));
        }
    }
}
