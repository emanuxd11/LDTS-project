package org.l11gr05.arena.ghost.ghostStates;

public class HouseState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new HouseState();
    }
}
