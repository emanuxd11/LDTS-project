package org.l11gr05.model.elements.ghost.ghostStates;

import org.l11gr05.model.elements.ghost.Ghost;
import org.l11gr05.sound.SoundFX;

public class HunterState implements IGhostState{
    private Ghost ghost;
    public HunterState(Ghost ghost){
        this.ghost = ghost;
    }

    @Override
    public void powerPelletEaten(){
        this.ghost.setState(new ChasedState(this.ghost));
    }

    @Override
    public void pacManCollision() {
        try {
            SoundFX.stopGameSounds();
        }catch (NullPointerException e){}
        this.ghost.setState(new HunterState(this.ghost));
    }

    @Override
    public boolean isBeingChased() {
        return false;
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public void increaseTimer() {

    }
}
