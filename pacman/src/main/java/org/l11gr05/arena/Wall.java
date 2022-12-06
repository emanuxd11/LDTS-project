package org.l11gr05.arena;


import org.l11gr05.elements.Element;
import org.l11gr05.elements.Position;

public class Wall extends Element {

    public Wall(Position position) {
        super(position);
    }

    public Wall(int x, int y){
        super(x, y);
    }

}
