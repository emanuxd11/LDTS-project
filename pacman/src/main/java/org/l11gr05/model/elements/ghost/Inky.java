package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.ghost.ghostStrategies.IGhostStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.InkyStrategy;

public class Inky extends Ghost {


    public Inky(int x, int y, IGhostStrategy strategy) {
        super(x, y, strategy);
    }
}
