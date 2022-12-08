package org.l11gr05.viewer.game;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.Wall;
import org.l11gr05.classes.game.elements.PacDot;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.PowerPellet;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        // testing
        List<Wall> walls = this.getModel().getWalls();
        List<PacDot> pacDots = this.getModel().getPacDots();
        List<PowerPellet> powerPellets = this.getModel().getPowerPellets();

        Pacman pacman = new Pacman();


        PacmanViewer pacmanViewer = new PacmanViewer();
        WallViewer wallViewer = new WallViewer();
        PacDotViewer pacDotViewer = new PacDotViewer();
        PowerPelletsViewer powerPelletsViewer = new PowerPelletsViewer();

        for (Wall wall : walls){
            wallViewer.draw(wall, gui);
        }

        for (PacDot pacDot : pacDots){
            pacDotViewer.draw(pacDot, gui);
        }

        for (PowerPellet powerPellet : powerPellets){
            powerPelletsViewer.draw(powerPellet, gui);
        }
        pacmanViewer.draw(pacman, gui);
    }
}
