package org.l11gr05.elements.ghost.ghostStates;

public class HouseState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new HouseState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new HouseState();
    }
}
