package org.l11gr05.viewer.game;

import org.l11gr05.arena.Wall;
import org.l11gr05.gui.GUI;

public class WallViewer implements IElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
