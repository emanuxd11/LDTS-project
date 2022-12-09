package org.l11gr05.classes.game.arena;

import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.Ghost;

public interface IArenaObservable {
    public void powerPelletEaten();

    public Ghost isGhost(Position position);
}
