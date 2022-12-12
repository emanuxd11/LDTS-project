package org.l11gr05.controller.menu;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.ArenaFactory;
import org.l11gr05.controller.Controller;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.sound.SoundFX;
import org.l11gr05.states.GameState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // SoundFX.stopGameSounds();
        SoundFX.getMenuTheme().loop();
        switch (action) {
            case UP -> this.getModel().previousEntry();
            case DOWN -> this.getModel().nextEntry();
            case SELECT -> {
                if (getModel().exitSelected()) {
                    SoundFX.stopMenuSounds();
                    game.setState(null);
                }
                if (getModel().startSelected()) {
                    // testing
                    SoundFX.stopMenuSounds();
                    // comentei porque fica irritante sem o delay no início
                    // SoundFX.getStartUp().play();
                    ////////////////////////
                    ArenaFactory temp = new ArenaFactory();
                    Arena arena = temp.createArena("map.txt");
                    game.setState(new GameState(arena));
                }
            }
        }
    }
}
