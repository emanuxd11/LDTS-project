package org.l11gr05.classes.game.elements.ghost.ghostStrategies;

import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.Position;

import java.util.List;

public interface IGhostStrategy {
    Position nextTargetMove(Pacman pacman, List<Position> possibles);
    Position nextScatorMove(Pacman pacman, List<Position> possibles);
}
