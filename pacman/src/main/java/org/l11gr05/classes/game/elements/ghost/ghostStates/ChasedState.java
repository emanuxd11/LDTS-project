package org.l11gr05.classes.game.elements.ghost.ghostStates;

public class ChasedState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        return new ChasedState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new EatenState();
    }
}
