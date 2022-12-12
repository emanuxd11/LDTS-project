package org.l11gr05.classes.game.elements.ghost.ghostStates;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.sound.SoundFX;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ChasedState implements IGhostState {

    int timer;
    public ChasedState(){
        this.timer = 0;
    }
    @Override
    public IGhostState powerPelletEaten() {
        this.timer = 0;
        // isto para o toque antigo e voltar a tocar do início,
        // só que depois o som já não toca mais por alguma razão :(
        SoundFX.getPowerUp().stop();
        SoundFX.getPowerUp().play();
        return this;
    }

    @Override
    public IGhostState pacManCollision() {
        SoundFX.getPacmanEatsGhost().play();
        return new EatenState();
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
