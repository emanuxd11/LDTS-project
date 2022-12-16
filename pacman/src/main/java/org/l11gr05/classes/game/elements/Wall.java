package org.l11gr05.classes.game.elements;


import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.Element;

public class Wall extends Element {

    public Wall(Position position) {
        super(position);
    }

    public Wall(int x, int y){
        super(x, y);
    }

}
