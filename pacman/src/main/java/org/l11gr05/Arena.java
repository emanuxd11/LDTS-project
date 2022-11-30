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
    Pacman pacman;

    public Arena(int height, int width){
        this.height = height;
        this.width = width;
    }

    private void detectCollision() {
        for (Ghost ghost : ghosts) {
            if (pacman.getPosition().equals(ghost.getPosition())) {
                ghost.getGhostState();
            }
        }
    }
    
}
