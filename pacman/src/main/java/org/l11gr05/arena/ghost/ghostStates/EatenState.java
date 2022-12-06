package org.l11gr05.arena.ghost.ghostStates;

import org.l11gr05.arena.ghost.Ghost;

public class EatenState implements IGhostState{

    private Ghost ghost;

    public EatenState(Ghost ghost){
        this.ghost = ghost;
    }


    @Override
    public void powerPelletEaten() {
        //Hunter State
        this.ghost.setState(new HunterState(this.ghost));
    }

    @Override
    public void pacManCollision() {
        this.ghost.setState(new EatenState(this.ghost));
    }
}
