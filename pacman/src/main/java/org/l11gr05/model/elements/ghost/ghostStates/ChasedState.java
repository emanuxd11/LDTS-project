package org.l11gr05.model.elements.ghost.ghostStates;

import org.l11gr05.model.elements.ghost.Ghost;
import org.l11gr05.sound.SoundFX;

public class ChasedState implements IGhostState {

    private int timer;
    private Ghost ghost;
    public ChasedState(Ghost ghost){
        this.timer = 0;
        this.ghost = ghost;
    }
    @Override
    public void powerPelletEaten() {
        this.timer = 0;
    }

    @Override
    public void pacManCollision() throws NullPointerException {
        try {
            SoundFX.playPacmanEatsGhost();
        }
        catch(NullPointerException e){}
        this.ghost.setState(new EatenState(this.ghost));
    }

    @Override
    public boolean isBeingChased() {
        return true;
    }

    @Override
    public int getTimer() {
        return this.timer;
    }

    @Override
    public void increaseTimer() {
        this.timer++;
    }
}
