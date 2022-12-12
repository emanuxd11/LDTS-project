package org.l11gr05.classes.game.arena;

import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.Ghost;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface IArenaObservable {
    void powerPelletEaten();

    Ghost isGhost(Position position) throws UnsupportedAudioFileException, LineUnavailableException, IOException;
}
