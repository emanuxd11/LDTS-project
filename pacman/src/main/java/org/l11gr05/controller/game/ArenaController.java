package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.sound.SoundFX;
import org.l11gr05.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController{

    private final GhostController ghostController;
    private final PacmanController pacmanController;

    public ArenaController(Arena arena) {
        super(arena);
        this.ghostController = new GhostController(arena);
        this.pacmanController = new PacmanController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            SoundFX.stopGameSounds();
            game.setState(new MenuState(new Menu()));
        } else {
            ghostController.step(game, action, time);
            pacmanController.step(game, action, time);
        }
    }
}
