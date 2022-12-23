package org.l11gr05.model.elements.ghost.ghostStates;

import org.l11gr05.model.elements.ghost.Ghost;

public class EatenState implements IGhostState {

    private final Ghost ghost;

    public EatenState(Ghost ghost) {
        this.ghost = ghost;
    }


    @Override
    public void powerPelletEaten() {
        this.ghost.setState(new HunterState(this.ghost));
    }

    @Override
    public void pacManCollision() {}

    @Override
    public boolean isBeingChased() {
        return false;
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public void increaseTimer() {}
}
