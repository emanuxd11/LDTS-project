package org.l11gr05.model.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.ghost.Blinky;
import org.l11gr05.model.elements.ghost.Clyde;
import org.l11gr05.model.elements.ghost.Inky;
import org.l11gr05.model.elements.ghost.Pinky;
import org.l11gr05.model.elements.ghost.ghostStates.ChasedState;
import org.l11gr05.model.elements.ghost.ghostStates.EatenState;
import org.l11gr05.model.elements.ghost.ghostStates.HouseState;
import org.l11gr05.model.elements.ghost.ghostStates.HunterState;
import org.l11gr05.model.elements.ghost.ghostStrategies.BlinkyStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.ClydeStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.InkyStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.PinkyStrategy;

public class GhostTest {

    @Test
    public void PositionTest(){
        Blinky blinky = new Blinky(5, 10, new BlinkyStrategy());
        Position expected = new Position(5, 10);
        Assertions.assertEquals(expected, blinky.getPosition());
    }

    @Test
    public void BlinkyStrategyTest(){
        Blinky blinky = new Blinky(10, 10, new BlinkyStrategy());
        Assertions.assertEquals(blinky.getStrategy().getClass(), BlinkyStrategy.class);
    }

    @Test
    public void ClydeStrategyTest(){
        Clyde clyde = new Clyde(10, 10, new ClydeStrategy());
        Assertions.assertEquals(clyde.getStrategy().getClass(), ClydeStrategy.class);
    }

    @Test
    public void InkyStrategyTest(){
        Inky inky = new Inky(10, 10, new InkyStrategy());
        Assertions.assertEquals(inky.getStrategy().getClass(), InkyStrategy.class);
    }

    @Test
    public void PinkyStrategyTest(){
        Pinky pinky = new Pinky(10, 10, new PinkyStrategy());
        Assertions.assertEquals(pinky.getStrategy().getClass(), PinkyStrategy.class);
    }

    @Test
    public void setStrategyTest(){
        Pinky pinky = new Pinky(10, 10, new PinkyStrategy());
        pinky.setStrategy(new BlinkyStrategy());
        Assertions.assertEquals(pinky.getStrategy().getClass(), BlinkyStrategy.class);
    }

    @Test
    public void powerPelletHouseState(){
        Clyde clyde = new Clyde(10, 10, new ClydeStrategy());
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), HouseState.class);
    }

    @Test
    public void powerPelletHunterState(){
        Clyde clyde = new Clyde(10, 10, new ClydeStrategy());
        clyde.setState(new HunterState(clyde));
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), ChasedState.class);
    }

    @Test
    public void powerPelletChasedState(){
        Clyde clyde = new Clyde (10, 10, new ClydeStrategy());
        clyde.setState(new ChasedState(clyde));
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), ChasedState.class);
    }

    @Test
    public void powerPelletEatenState(){
        Clyde clyde = new Clyde(10, 10, new ClydeStrategy());
        clyde.setState(new EatenState(clyde));
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), HunterState.class);
    }

    @Test
    public void pacManCollisionChasedState(){
        Inky inky = new Inky(10, 10, new InkyStrategy());
        inky.setState(new ChasedState(inky));
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), EatenState.class);
    }

    @Test
    public void pacManCollisionEatenState(){
        Inky inky = new Inky(10, 10, new InkyStrategy());
        inky.setState(new EatenState(inky));
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), EatenState.class);
    }

    @Test
    public void pacManCollisionHouseState(){
        Inky inky = new Inky(10, 10, new InkyStrategy());
        inky.setState(new HouseState(inky));
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), HouseState.class);
    }

    @Test
    public void pacManCollisionHunterState(){
        Inky inky = new Inky (10, 10, new InkyStrategy());
        inky.setState(new HunterState(inky));
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), HunterState.class);
    }

}
