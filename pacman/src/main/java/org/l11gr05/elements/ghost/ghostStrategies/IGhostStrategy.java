package org.l11gr05.elements.ghost.ghostStrategies;

import org.l11gr05.elements.Position;

public interface IGhostStrategy {
    public Position nextTargetMove(Position pacManPosition);
    public Position nextScatorMove(Position pacManPosition);
}
