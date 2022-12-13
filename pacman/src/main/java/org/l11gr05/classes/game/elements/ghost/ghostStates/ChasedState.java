package org.l11gr05.classes.game.elements.ghost.ghostStates;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.elements.ghost.Ghost;
import org.l11gr05.sound.SoundFX;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

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
        // isto para o toque antigo e voltar a tocar do início,
        // só que depois o som já não toca mais por alguma razão :(
        // SoundFX.getPowerUp().stop();
        // SoundFX.getPowerUp().play();
    }

    @Override
    public void pacManCollision() {
        SoundFX.getPacmanEatsGhost().stop();
        SoundFX.getPacmanEatsGhost().play();
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
