package org.l11gr05.arena.ghost.ghostStates;

import org.l11gr05.arena.ghost.Ghost;

public class HunterState implements IGhostState{

    Ghost ghost;

    public HunterState(Ghost ghost){
        this.ghost = ghost;
    }
    @Override
    public void powerPelletEaten() {
        this.ghost.setState(new ChasedState(this.ghost));;
    }

    @Override
    public void pacManCollision() {
        this.ghost.setState(new HunterState(this.ghost));;
    }
}
