package org.l11gr05.classes.game.elements.ghost.ghostStates;

public interface IGhostState {

    IGhostState powerPelletEaten();

    IGhostState pacManCollision();

    public int getTimer();

    public void increaseTimer();
}
