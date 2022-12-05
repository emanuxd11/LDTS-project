package org.l11gr05.arena;

import org.l11gr05.arena.ghost.IArenaObserver;

import java.util.ArrayList;
import java.util.List;

public class Arena implements IArenaObservable {
    private int height;
    private int width;
    List<Wall> walls = new ArrayList<Wall>();
    List<PacDot> pacDots = new ArrayList<PacDot>();
    List<PowerPellet> powerPellets = new ArrayList<PowerPellet>();

    List<IArenaObserver> ghosts = new ArrayList<>();

    public Arena(int width, int heigth){
        this.width = width;
        this.height = heigth;
        this.walls = new ArrayList<Wall>();
        this.pacDots = new ArrayList<PacDot>();
        this.powerPellets = new ArrayList<PowerPellet>();
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

    public void addPowerPellet(PowerPellet powerPellet){
        powerPellets.add(powerPellet);
    }

    public void addGhost(IArenaObserver ghost){
        ghosts.add(ghost);
    }

    public List<IArenaObserver> getGhosts(){
        return this.ghosts;
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
}
