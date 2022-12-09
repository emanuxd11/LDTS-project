package org.l11gr05.classes.game.elements.ghost.ghostStates;

import org.l11gr05.classes.game.arena.Arena;

public class ChasedState implements IGhostState {

    int timer;
    public ChasedState(){
        this.timer = 0;
    }
    @Override
    public IGhostState powerPelletEaten() {
        this.timer = 0;
        return this;
    }

    @Override
    public IGhostState pacManCollision() {
        return new EatenState();
    }

    @Override
    public int getTimer() {
        return this.timer;
    }

    @Override
    public void increaseTimer() {
        this.timer++;
    }
}
