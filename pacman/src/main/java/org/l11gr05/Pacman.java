package org.l11gr05;

import org.l11gr05.arena.Element;
import org.l11gr05.arena.Position;

public class Pacman extends Element {
    public Pacman(Position position) {
        super(position);
    }

    public Pacman() {
        super(new Position(5, 5));
    }


}
