package org.l11gr05.elements.ghost.ghostStates;

public class HunterState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new ChasedState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new HunterState();
    }
}