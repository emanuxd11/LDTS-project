package org.l11gr05.arena.ghost.ghostStrategies;

import org.l11gr05.arena.Position;

import java.util.List;

public interface IGhostStrategy {
    public Position nextTargetMove(Position pacManPosition, List<Position> possibles);
    public Position nextScatorMove(Position pacManPosition, List<Position> possibles);
}
