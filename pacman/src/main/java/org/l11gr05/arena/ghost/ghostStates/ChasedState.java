package org.l11gr05.arena.ghost.ghostStates;

import org.l11gr05.arena.ghost.Ghost;
import org.l11gr05.arena.ghost.IArenaObserver;

public class ChasedState implements IGhostState {

    private Ghost ghost;

    public ChasedState(Ghost ghost){
        this.ghost = ghost;
    }
    @Override
    public void powerPelletEaten() {
        this.ghost.setState(new ChasedState(this.ghost));
    }

    @Override
    public void pacManCollision() {
        this.ghost.setState(new EatenState(this.ghost));
    }
}
