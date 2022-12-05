package org.l11gr05.arena.ghost;

import org.l11gr05.arena.Position;
import org.l11gr05.arena.ghost.ghostStates.IGhostState;
import org.l11gr05.arena.ghost.ghostStrategies.BlinkyStrategy;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

public class Blinky extends Ghost {

    public Blinky(int x, int y) {
        super(x, y);
        this.strategy = new BlinkyStrategy();
    }

}
