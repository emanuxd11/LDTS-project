package org.l11gr05.elements.ghost.ghostStrategies;

import org.l11gr05.elements.Position;

public interface IGhostStrategy {
    Position nextTargetMove(Position pacManPosition);
    Position nextScatorMove(Position pacManPosition);
}
