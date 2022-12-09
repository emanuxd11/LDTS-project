package org.l11gr05.classes.game.elements.ghost.ghostStates;

public class HouseState implements IGhostState{

    private int timer;
    public HouseState(){
        this.timer = 0;
    }
    @Override
    public IGhostState powerPelletEaten() {
        return new ChasedState();
    }

    @Override
    public IGhostState pacManCollision() {
        return new HouseState();
    }

    public void increaseTimer(){
        this.timer++;
    }

    public int getTimer(){
        return this.timer;
    }
}
