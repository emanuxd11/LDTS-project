package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.ghost.ghostStates.HunterState;
import org.l11gr05.model.elements.ghost.ghostStrategies.IGhostStrategy;

public class Blinky extends Ghost {

    public Blinky(int x, int y, IGhostStrategy strategy) {
        super(x, y, strategy);
        this.state = new HunterState(this);
    }
}
