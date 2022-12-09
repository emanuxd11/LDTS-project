package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.Ghost;
import org.l11gr05.classes.game.elements.ghost.ghostStates.EatenState;
import org.l11gr05.classes.game.elements.ghost.ghostStates.HunterState;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.states.MenuState;

import java.io.IOException;
import java.util.List;

public class GhostController extends GameController {

    public GhostController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException{
        List<Position> neighbours;
        for (Ghost ghost : this.getModel().getGhosts()) {
            neighbours = ghost.getAllNeighbours();
            neighbours.removeIf(n -> (!getModel().isEmpty(n)));
            Position temp = ghost.nextMove(neighbours, this.getModel().getPacman());
            moveGhost(ghost, temp);
        }
    }

    private void moveGhost(Ghost ghost, Position position) {
        if (ghost.getState().getClass() == EatenState.class){
            ghost.setPosition(new Position(13, 14));
            ghost.setState(new HunterState());
        }

        else {
            ghost.setPosition(position);
            if (this.getModel().getPacman().getPosition().equals(ghost.getPosition())) {
                ghost.getState().pacManCollision();
            }
        }
    }
}

