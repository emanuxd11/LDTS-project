package org.l11gr05.arena.ghost;

import org.l11gr05.arena.Position;

public interface IGhostStrategy {
    public Position nextTargetMove();
    public Position nextScatorMove();
}
