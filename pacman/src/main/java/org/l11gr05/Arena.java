package org.l11gr05;

import org.l11gr05.ghost.Ghost;

import java.util.List;

public class Arena implements IArenaObservable{
    int height;
    int width;
    List<Ghost> ghosts;
    List<Wall> walls;
    List<PacDot> pacDots;
    List<PowerPellets> powerPellets;

    public Arena(int height, int width){
        this.height = height;
        this.width = width;
    }

    
}
