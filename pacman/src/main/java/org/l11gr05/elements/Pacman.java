package org.l11gr05.elements;

import org.l11gr05.elements.Element;
import org.l11gr05.elements.Position;

public class Pacman extends Element {
    public Pacman(Position position) {
        super(position);
    }

    public Pacman() {
        super(new Position(5, 5));
    }
}
