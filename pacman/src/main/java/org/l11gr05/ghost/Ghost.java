package org.l11gr05.ghost;

import org.l11gr05.Element;
import org.l11gr05.Position;
import org.l11gr05.ghost.GhostStates.HouseState;
import org.l11gr05.ghost.GhostStates.IGhostState;

public abstract class Ghost extends Element implements IArenaObserver {
    private IGhostState state;
    public Ghost(Position position) {
        super(position);
        this.state = new HouseState();
    }

    public IGhostState getGhostState() {
        return state;
    }
}
