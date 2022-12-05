package org.l11gr05.arena.ghost.ghostStrategies;

import org.l11gr05.arena.Position;

public interface IGhostStrategy {
    public Position nextTargetMove(Position pacManPosition);
    public Position nextScatorMove(Position pacManPosition);
}
