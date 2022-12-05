package org.l11gr05.arena.ghost;

import org.l11gr05.arena.Element;
import org.l11gr05.arena.Position;
import org.l11gr05.arena.ghost.ghostStates.HouseState;
import org.l11gr05.arena.ghost.ghostStates.IGhostState;
import org.l11gr05.arena.ghost.ghostStrategies.IGhostStrategy;


public abstract class Ghost extends Element implements IArenaObserver{

    protected IGhostStrategy strategy;
    protected IGhostState state;

    public Ghost(int x, int y){
        super(x, y);
        this.state = new HouseState();
    }

    public Position move(Position pacManPosition){
        return null;
    }

    public void powerPelletEaten(){
        this.state = this.state.powerPelletEaten();
    }

    public IGhostState getState(){
        return this.state;
    }

    public IGhostStrategy getStrategy(){
        return this.strategy;
    }

    public void setState(IGhostState state){
        this.state = state;
    }

    public void pacManCollision(){
        this.state = this.state.pacManCollision();
    }

}