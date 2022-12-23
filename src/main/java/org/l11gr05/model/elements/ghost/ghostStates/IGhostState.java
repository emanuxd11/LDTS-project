package org.l11gr05.model.elements.ghost.ghostStates;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface IGhostState {

    void powerPelletEaten();

    void pacManCollision();

    boolean isBeingChased();

    int getTimer();

    void increaseTimer();
}
