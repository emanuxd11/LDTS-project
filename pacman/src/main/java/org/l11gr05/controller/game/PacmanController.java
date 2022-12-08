package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.elements.Position;
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

        Position pacmanPositon = this.getModel().getPacman().getPosition();
        if (this.getModel().getPacman().getDirection() == 'u') {
            if (this.getModel().isEmpty(new Position(pacmanPositon.getX(), pacmanPositon.getY()-1))) {
                this.getModel().getPacman().moveUp();
            }
        }

        if (this.getModel().getPacman().getDirection() == 'd'){
            if (this.getModel().isEmpty(new Position(pacmanPositon.getX(), pacmanPositon.getY()+1))){
                this.getModel().getPacman().moveDown();
            }

        };
        if (this.getModel().getPacman().getDirection() == 'r'){
            if((this.getModel().getPacman().getPosition().getX() == 22 && this.getModel().getPacman().getPosition().getY() == 10)){
                this.getModel().getPacman().setPosition(new Position(0, 10));
            }
            else {
                if (this.getModel().isEmpty(new Position(pacmanPositon.getX() + 1, pacmanPositon.getY()))) {
                    this.getModel().getPacman().moveRight();
                }
            }
        }

        if (this.getModel().getPacman().getDirection() == 'l'){
            if((this.getModel().getPacman().getPosition().getX() == 0 && this.getModel().getPacman().getPosition().getY() == 10)){
                this.getModel().getPacman().setPosition(new Position(22, 10));
            }
            else {
                if (this.getModel().isEmpty(new Position(pacmanPositon.getX() - 1, pacmanPositon.getY()))) {
                    this.getModel().getPacman().moveLeft();
                }
            }
        }

    }
}
