package org.l11gr05.controller.menu;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.ArenaFactory;
import org.l11gr05.controller.Controller;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.states.GameState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action) {
            case UP:
                this.getModel().previousEntry();
                break;
            case DOWN:
                this.getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().exitSelected()) game.setState(null);
                if (getModel().startSelected()) {
                    /* só um teste mas já funciona
                       mais tarde eu arranjo
                    AudioTest audioTest = new AudioTest();
                    audioTest.play(); */

                    ArenaFactory temp = new ArenaFactory();
                    Arena arena = temp.createArena("map.txt");
                    game.setState(new GameState(arena));
                }
        }
    }
}
