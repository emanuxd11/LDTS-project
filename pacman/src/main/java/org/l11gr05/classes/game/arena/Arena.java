package org.l11gr05.classes.game.arena;

import org.l11gr05.classes.game.elements.PacDot;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.PowerPellet;
import org.l11gr05.classes.game.elements.ghost.Ghost;

import java.util.ArrayList;
import java.util.List;

public class Arena implements IArenaObservable {
    private int height;

    private Pacman pacman;
    private int width;

    List<Ghost> ghosts;
    List<Wall> walls = new ArrayList<Wall>();
    List<PacDot> pacDots = new ArrayList<PacDot>();
    List<PowerPellet> powerPellets = new ArrayList<PowerPellet>();

    public Arena(int width, int heigth){
        this.width = width;
        this.height = heigth;
        this.walls = new ArrayList<Wall>();
        this.pacDots = new ArrayList<PacDot>();
        this.powerPellets = new ArrayList<PowerPellet>();
        this.pacman = new Pacman(new Position(5, 5), 'r');
    }


    public Pacman getPacman(){
        return this.pacman;
    }

    public Arena(){
        this.width = 0;
        this.height = 0;
    }

    public void setSize(int width, int heigth){
        this.width = width;
        this.height = heigth;
    }

    public void addWall(Wall wall){
        walls.add(wall);
    }

    public void addPacDot(PacDot pacDot){
        pacDots.add(pacDot);
    }

    public List<Ghost> getGhosts(){
        return this.ghosts;
    }

    public void addPowerPellet(PowerPellet powerPellet){
        powerPellets.add(powerPellet);
    }

    public int getHeight(){
        return this.height;
    }

    public List<Wall> getWalls(){
        return this.walls;
    }

    public List<PowerPellet> getPowerPellets(){
        return this.powerPellets;
    }

    public int getWidth(){
        return this.width;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
}
