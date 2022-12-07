package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.gui.GUI;

import java.io.IOException;

public class PacmanController extends GameController{

    public PacmanController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) this.getModel().getPacman().setDirection('u');
        if (action == GUI.ACTION.DOWN) this.getModel().getPacman().setDirection('d');
        if (action == GUI.ACTION.LEFT) this.getModel().getPacman().setDirection('l');
        if (action == GUI.ACTION.RIGHT) this.getModel().getPacman().setDirection('r');

        if (this.getModel().getPacman().getDirection() == 'u') this.getModel().getPacman().moveUp();
        if (this.getModel().getPacman().getDirection() == 'd') this.getModel().getPacman().moveDown();
        if (this.getModel().getPacman().getDirection() == 'r') this.getModel().getPacman().moveRight();
        if (this.getModel().getPacman().getDirection() == 'l') this.getModel().getPacman().moveLeft();
    }
}
