package org.l11gr05.classes.game.elements.ghost;

import org.l11gr05.classes.game.elements.ghost.ghostStrategies.BlinkyStrategy;

public class Blinky extends Ghost {

    public Blinky(int x, int y) {
        super(x, y);
        this.strategy = new BlinkyStrategy();
    }

}
