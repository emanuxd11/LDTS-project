package org.l11gr05.viewer.game;

import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.elements.Wall;
import org.l11gr05.model.elements.PacDot;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.PowerPellet;
import org.l11gr05.gui.GUI;
import org.l11gr05.sound.SoundFX;
import org.l11gr05.viewer.Viewer;
import org.l11gr05.viewer.game.ghost.BlinkyViewer;
import org.l11gr05.viewer.game.ghost.ClydeViewer;
import org.l11gr05.viewer.game.ghost.InkyViewer;
import org.l11gr05.viewer.game.ghost.PinkyViewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena model) {
        super(model);
        SoundFX.playStartUp();
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0),
                "SCORE:" + this.getModel().getPacman().getScore(), "#FFFFFF");
        gui.drawText(new Position(12, 0),
                "HIGHSCORE:" + this.getModel().getPacman().getHighScore(), "#FFFFFF");
        gui.drawText(new Position(0, 32), "Q to quit", "#FFFFFF");

        List<Wall> walls = this.getModel().getWalls();
        List<PacDot> pacDots = this.getModel().getPacDots();
        List<PowerPellet> powerPellets = this.getModel().getPowerPellets();
        Pacman pacman = this.getModel().getPacman();

        PacmanViewer pacmanViewer = new PacmanViewer();
        WallViewer wallViewer = new WallViewer();
        PacDotViewer pacDotViewer = new PacDotViewer();
        PowerPelletsViewer powerPelletsViewer = new PowerPelletsViewer();
        BlinkyViewer blinkyViewer = new BlinkyViewer();
        InkyViewer inkyViewer = new InkyViewer();
        PinkyViewer pinkyViewer = new PinkyViewer();
        ClydeViewer clydeViewer = new ClydeViewer();

        for (Wall wall : walls){
            wallViewer.draw(wall, gui);
        }

        for (PacDot pacDot : pacDots){
            pacDotViewer.draw(pacDot, gui);
        }

        for (PowerPellet powerPellet : powerPellets){
            powerPelletsViewer.draw(powerPellet, gui);
        }

        blinkyViewer.draw(this.getModel().getBlinky(), gui);
        inkyViewer.draw(this.getModel().getInky(), gui);
        pinkyViewer.draw(this.getModel().getPinky(), gui);
        clydeViewer.draw(this.getModel().getClyde(), gui);

        pacmanViewer.draw(pacman, gui);

    }
}
