package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.ghost.Ghost;
import org.l11gr05.model.elements.ghost.ghostStates.ChasedState;
import org.l11gr05.model.elements.ghost.ghostStates.EatenState;
import org.l11gr05.model.elements.ghost.ghostStates.HouseState;
import org.l11gr05.model.elements.ghost.ghostStates.HunterState;
import org.l11gr05.gui.GUI;
import org.l11gr05.sound.SoundFX;

import java.util.List;

public class GhostController extends GameController {

    private long lastmovement;

    public GhostController(Arena arena) {
        super(arena);
        this.lastmovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        List<Position> neighbours;
        if (time - lastmovement > 150) {
            for (Ghost ghost : this.getModel().getGhosts()) {
                try {
                    neighbours = ghost.getAllNeighbours();
                    neighbours.removeIf(n -> !getModel().isEmpty(n));
                    Position temp = ghost.nextMove(neighbours, this.getModel().getPacman());
                    if (temp.equals(new Position(0, 0))) {
                        temp = new Position(15, 14);
                        ghost.setState(new HouseState(ghost));
                    }
                    moveGhost(ghost, temp);
                } catch (NullPointerException e){}
            }
            this.lastmovement = time;
        }
    }

    private void moveGhost(Ghost ghost, Position position) {
        if (ghost.getState().getClass() == EatenState.class){
            ghost.setPosition(new Position(13, 14));
            ghost.setState(new HouseState(ghost));
        }

        else if (ghost.getState().getClass() == HouseState.class){
            if (ghost.getState().getTimer() > 10) {
                ghost.setPosition(new Position(15, 11));
                ghost.setState(new HunterState(ghost));
            }
            else {
                ghost.setPosition(position);
                ghost.getState().increaseTimer();
            }
        }

        else if (ghost.getState().getClass() == ChasedState.class){
            if (ghost.getState().getTimer() > 60) {
                SoundFX.loopGhostSiren1();
                ghost.setState(new HunterState(ghost));
            }
            ghost.getState().increaseTimer();
            if(position.equals(new Position(-1, 14)) || position.equals(new Position(-2, 14))) ghost.setPosition(new Position(27, 14));
            else if(position.equals(new Position(27, 14)) || position.equals(new Position(28, 14))) ghost.setPosition(new Position(0, 14));
            else ghost.setPosition(position);
        }

        else {
            if (position.equals(new Position(0, 14))) ghost.setPosition(new Position(27, 14));
            else if (position.equals(new Position(27, 14))) ghost.setPosition(new Position(0, 14));
            else ghost.setPosition(position);

            if (this.getModel().getPacman().getPosition().equals(ghost.getPosition())) {
                ghost.getState().pacManCollision();
            }
        }
    }
}

