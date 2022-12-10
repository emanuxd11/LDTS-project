package org.l11gr05.classes.game.elements.ghost.ghostStates;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface IGhostState {

    IGhostState powerPelletEaten();

    IGhostState pacManCollision() throws UnsupportedAudioFileException, LineUnavailableException, IOException;

    public int getTimer();

    public void increaseTimer();
}
