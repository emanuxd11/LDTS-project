package org.l11gr05.viewer.game;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.Wall;
import org.l11gr05.classes.game.elements.PacDot;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.PowerPellet;
import org.l11gr05.classes.game.elements.ghost.Blinky;
import org.l11gr05.classes.game.elements.ghost.Ghost;
import org.l11gr05.classes.game.elements.ghost.IArenaObserver;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.Viewer;
import org.l11gr05.viewer.game.ghost.BlinkyViewer;
import org.l11gr05.viewer.game.ghost.ClydeViewer;
import org.l11gr05.viewer.game.ghost.InkyViewer;
import org.l11gr05.viewer.game.ghost.PinkyViewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
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
