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
        SoundFX powerUp = new SoundFX("powerUp.wav");
        powerUp.play();
        return this;
    }

    @Override
    public IGhostState pacManCollision() {
        SoundFX pacmanEatsGhost = new SoundFX("pacmanEatsGhost.wav");
        pacmanEatsGhost.play();
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
