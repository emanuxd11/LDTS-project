package org.l11gr05.model.elements.ghost.ghostStates;

import org.l11gr05.model.elements.ghost.Ghost;

public class HouseState implements IGhostState{

    private int timer;
    private Ghost ghost;
    public HouseState(Ghost ghost){
        this.timer = 0;
        this.ghost = ghost;
    }
    @Override
    public void powerPelletEaten() {
    }

    @Override
    public void pacManCollision() {
        this.ghost.setState(new HouseState(this.ghost));
    }

    @Override
    public boolean isBeingChased() {
        return false;
    }

    public void increaseTimer(){
        this.timer++;
    }

    public int getTimer(){
        return this.timer;
    }
}
