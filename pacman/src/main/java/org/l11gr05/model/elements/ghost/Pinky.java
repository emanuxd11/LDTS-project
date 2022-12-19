package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.ghost.ghostStrategies.IGhostStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.PinkyStrategy;

public class Pinky extends Ghost {


    public Pinky(int x, int y, IGhostStrategy strategy) {
        super(x, y, strategy);
    }
}
