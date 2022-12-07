package org.l11gr05.classes.game.elements.ghost;

import org.l11gr05.classes.game.elements.ghost.ghostStrategies.InkyStrategy;

public class Inky extends Ghost {

    public Inky(int x, int y) {
        super(x, y);
        this.strategy = new InkyStrategy();
    }
}
