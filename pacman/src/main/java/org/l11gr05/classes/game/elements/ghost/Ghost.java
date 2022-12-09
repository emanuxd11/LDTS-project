package org.l11gr05.classes.game.elements.ghost;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.Position;
import org.l11gr05.classes.game.elements.ghost.ghostStates.ChasedState;
import org.l11gr05.classes.game.elements.ghost.ghostStates.HouseState;
import org.l11gr05.classes.game.elements.ghost.ghostStates.HunterState;
import org.l11gr05.classes.game.elements.ghost.ghostStates.IGhostState;
import org.l11gr05.classes.game.elements.ghost.ghostStrategies.IGhostStrategy;

import java.util.List;


public abstract class Ghost extends Element implements IArenaObserver {

    protected IGhostStrategy strategy;
    protected IGhostState state;

    public Ghost(int x, int y){
        super(x, y);
        this.state = new HunterState();
    }

    public void move(Pacman pacman){
        List<Position> possibles = null;
        possibles.add(new Position(this.getPosition().getX(), this.getPosition().getY()+1));
        possibles.add(new Position(this.getPosition().getX(), this.getPosition().getY()-1));
        possibles.add(new Position(this.getPosition().getX()+1, this.getPosition().getY()));
        possibles.add(new Position(this.getPosition().getX()-1, this.getPosition().getY()));
        Position next = this.strategy.nextTargetMove(pacman, possibles);
        this.setPosition(next);
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

    public void powerPelletEaten(){
        IGhostState oldState = this.state;
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