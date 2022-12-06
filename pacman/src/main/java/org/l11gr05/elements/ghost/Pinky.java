package org.l11gr05.elements.ghost;

import org.l11gr05.elements.ghost.ghostStrategies.PinkyStrategy;

public class Pinky extends Ghost{

    public Pinky(int x, int y) {
        super(x, y);
        this.strategy = new PinkyStrategy();
    }

}
