package org.l11gr05.classes.game.elements.ghost.ghostStates;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
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
    }

    @Override
    public void pacManCollision() throws NullPointerException {
        try {
            SoundFX.getPacmanEatsGhost().stop();
            SoundFX.getPacmanEatsGhost().play();
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
