package org.l11gr05.elements.ghost;

import org.l11gr05.elements.ghost.ghostStrategies.BlinkyStrategy;

public class Blinky extends Ghost {

    public Blinky(int x, int y) {
        super(x, y);
        this.strategy = new BlinkyStrategy();
    }

}
