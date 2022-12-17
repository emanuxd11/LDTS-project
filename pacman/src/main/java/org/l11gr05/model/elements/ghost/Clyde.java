package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.ghost.ghostStrategies.ClydeStrategy;

public class Clyde extends Ghost {
    public Clyde(int x, int y) {
        super(x, y);
        this.strategy = new ClydeStrategy();
    }

}
