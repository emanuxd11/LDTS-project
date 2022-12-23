package org.l11gr05.controller.game;

import org.l11gr05.Game;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.ghost.ghostStates.HunterState;
import org.l11gr05.gui.GUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.sound.SoundFX;
import org.l11gr05.states.MenuState;

public class PacmanController extends GameController {
    public boolean alreadyPlayed = false;
    public PacmanController(Arena arena) {
        super(arena);
    }

    private boolean canMove(Position position) {
        return getModel().isEmpty(position);
    }

    public void movePacman(Position position) {
        if (canMove(position)) this.getModel().getPacman().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        Position pacmanPosition = this.getModel().getPacman().getPosition();

        if (action == GUI.ACTION.UP) {
            if (canMove(new Position(pacmanPosition.getX(), pacmanPosition.getY() - 1))) {
                this.getModel().getPacman().setDirection('u');
            }
        } else if (action == GUI.ACTION.DOWN) {
            if (canMove(new Position(pacmanPosition.getX(), pacmanPosition.getY() + 1))) {
                this.getModel().getPacman().setDirection('d');
            }
        } else if (action == GUI.ACTION.RIGHT) {
            if (canMove(new Position(pacmanPosition.getX() + 1, pacmanPosition.getY()))) {
                this.getModel().getPacman().setDirection('r');
            }
        } else if (action == GUI.ACTION.LEFT) {
            if (canMove(new Position(pacmanPosition.getX() - 1, pacmanPosition.getY()))) {
                this.getModel().getPacman().setDirection('l');
            }
        }

        if (this.getModel().isGhost(this.getModel().getPacman().getPosition()) != null) {
            if(this.getModel().isGhost(
                    this.getModel().getPacman().getPosition()).getState().getClass() == HunterState.class) {
                alreadyPlayed = true;
                SoundFX.stopGameSounds();
                SoundFX.playPacmanDies();
                game.setState(new MenuState(new Menu()));
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException ignored){}
            }
        }

        switch (this.getModel().getPacman().getDirection()) {
            case 'u' -> movePacman(new Position(pacmanPosition.getX(), pacmanPosition.getY() - 1));
            case 'd' -> movePacman((new Position(pacmanPosition.getX(), pacmanPosition.getY() + 1)));
            case 'l' -> {
                if (pacmanPosition.getX() <= 0 || pacmanPosition.getY() <= 0) {
                    this.getModel().getPacman().setDirection('l');
                    movePacman(this.getModel().getRightPortal());
                }
                else movePacman(new Position(pacmanPosition.getX() - 1, pacmanPosition.getY()));
            }
            case 'r' -> {
                if (pacmanPosition.getX() >= this.getModel().getWidth()-1 ||
                        pacmanPosition.getY() > this.getModel().getHeight()) {
                    movePacman(this.getModel().getLeftPortal());
                    this.getModel().getPacman().setDirection('r');
                }
                else movePacman(new Position(pacmanPosition.getX() + 1, pacmanPosition.getY()));
            }
        }

        this.getModel().pacDotRemove(this.getModel().getPacman().getPosition());
        this.getModel().powerPelletRemove(this.getModel().getPacman().getPosition());


        if (this.getModel().getPacDots().isEmpty() && this.getModel().getPowerPellets().isEmpty()) {
            SoundFX.stopGameSounds();
            game.setState(new MenuState(new Menu()));
        }

        if (this.getModel().isGhost(this.getModel().getPacman().getPosition()) != null) {
            if(this.getModel().isGhost(this.getModel().getPacman().getPosition()).getState().getClass() ==
                    HunterState.class) {
                if (!alreadyPlayed) {
                    SoundFX.stopGameSounds();
                    SoundFX.playPacmanDies();
                    game.setState(new MenuState(new Menu()));
                    try{
                        Thread.sleep(1500);
                    }catch(InterruptedException ignored){}
                }
            }
        }
    }
}
