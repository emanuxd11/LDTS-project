package org.l11gr05.classes.game.elements.ghost.ghostStates;

public class EatenState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new HunterState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new EatenState();
    }
}
