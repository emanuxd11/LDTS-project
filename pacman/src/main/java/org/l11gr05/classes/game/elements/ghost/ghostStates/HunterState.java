package org.l11gr05.classes.game.elements.ghost.ghostStates;

public class HunterState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new ChasedState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new HunterState();
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public void increaseTimer() {

    }
}
