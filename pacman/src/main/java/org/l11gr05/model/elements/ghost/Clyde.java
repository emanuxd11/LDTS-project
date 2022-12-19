package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.ghost.ghostStrategies.ClydeStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.IGhostStrategy;

public class Clyde extends Ghost {

    public Clyde(int x, int y, IGhostStrategy strategy) {
        super(x, y, strategy);
    }
}
