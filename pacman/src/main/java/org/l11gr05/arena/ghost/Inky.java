package org.l11gr05.arena.ghost;

import org.l11gr05.arena.ghost.ghostStrategies.InkyStrategy;

public class Inky extends Ghost{

    public Inky(int x, int y) {
        super(x, y);
        this.strategy = new InkyStrategy();
    }
}
