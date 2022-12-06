package org.l11gr05.arena.ghost.ghostStates;

import org.l11gr05.arena.ghost.Ghost;

public class HouseState implements IGhostState{

    Ghost ghost;

    public HouseState(Ghost ghost){
        this.ghost = ghost;
    }
    @Override
    public void powerPelletEaten() {
        this.ghost.setState(new HouseState(this.ghost));;
    }

    @Override
    public void pacManCollision() {
        this.ghost.setState(new HouseState(this.ghost));;
    }
}
