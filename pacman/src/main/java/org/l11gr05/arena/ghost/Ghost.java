package org.l11gr05.arena.ghost;

import org.l11gr05.arena.Position;
import org.l11gr05.arena.ghost.ghostStates.HouseState;
import org.l11gr05.arena.ghost.ghostStates.IGhostState;
import org.l11gr05.arena.ghost.ghostStrategies.IGhostStrategy;

import javax.lang.model.element.Element;

public abstract class Ghost implements IArenaObserver, Element {

    public IGhostStrategy strategy;
    private IGhostState state;

    public Ghost(){
        super();
        this.state = new HouseState();
    }

    public Position move(Position pacManPosition){
        return null;
    }

    public IGhostState powerPelletEaten(){

        return null;
    }
}