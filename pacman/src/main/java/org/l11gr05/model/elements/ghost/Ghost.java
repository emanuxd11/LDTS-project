package org.l11gr05.model.elements.ghost;

import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.ghost.ghostStates.ChasedState;
import org.l11gr05.model.elements.ghost.ghostStates.HouseState;
import org.l11gr05.model.elements.ghost.ghostStates.IGhostState;
import org.l11gr05.model.elements.ghost.ghostStrategies.IGhostStrategy;

import java.util.List;


public abstract class Ghost extends Element implements IArenaObserver {

    protected IGhostStrategy strategy;
    protected IGhostState state;

    public Ghost(int x, int y){
        super(x, y);
        this.state = new HouseState(this);
    }

    public Position nextMove(List<Position> neighbours, Pacman pacman){
        Position temp;
        if (ChasedState.class == this.state.getClass()) {
            temp = strategy.nextScatorMove(pacman, neighbours);
        }
        else{
            temp = strategy.nextTargetMove(pacman, neighbours);
        }
        return temp;
    }

    public void powerPelletEaten() {
        this.state.powerPelletEaten();
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

    public void pacManCollision() {
        this.state.pacManCollision();
    }

}