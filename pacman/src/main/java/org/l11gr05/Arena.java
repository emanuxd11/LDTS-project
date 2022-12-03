package org.l11gr05;

import org.l11gr05.ghost.Ghost;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Arena implements IArenaObservable{
    private int height;
    private int width;
    List<Ghost> ghosts;
    List<Wall> walls;
    List<PacDot> pacDots;
    List<PowerPellets> powerPellets;

    public Arena(int height, int width){
        this.height = height;
        this.width = width;
        this.walls = makeWalls();
    }

    public int getHeight(){
        return this.height;
    }

    public List<Wall> getWalls(){
        return this.walls;
    }

    public int getWidth(){
        return this.width;
    }

    private List<Wall> makeWalls(){

        List<Wall> wallsCreated = new ArrayList<Wall>();

        for (int i = 0; i < this.height;i++){
            Wall wall1 = new Wall(0, i);
            Wall wall2 = new Wall(width, i);
            wallsCreated.add(wall1);
            wallsCreated.add(wall2);
        }
        return wallsCreated;
    }
}
