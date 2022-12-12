package org.l11gr05.classes.game.elements.ghost.ghostStates;

import org.l11gr05.sound.SoundFX;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HunterState implements IGhostState{
    @Override
    public IGhostState powerPelletEaten() {
        SoundFX.getGhostSiren1().stop();
        SoundFX.getPowerUp().play();
        return new ChasedState();
    }

    @Override
    public IGhostState pacManCollision() {
        SoundFX.stopGameSounds();
        // só toca na primeira morte por alguma razão :(
        SoundFX.getPacmanDies().play();
        return new HunterState();
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public void increaseTimer() {

    }
}
