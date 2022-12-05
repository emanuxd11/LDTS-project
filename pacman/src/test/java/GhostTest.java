import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.arena.Position;
import org.l11gr05.arena.ghost.Blinky;
import org.l11gr05.arena.ghost.Clyde;
import org.l11gr05.arena.ghost.Inky;
import org.l11gr05.arena.ghost.Pinky;
import org.l11gr05.arena.ghost.ghostStates.ChasedState;
import org.l11gr05.arena.ghost.ghostStates.EatenState;
import org.l11gr05.arena.ghost.ghostStates.HouseState;
import org.l11gr05.arena.ghost.ghostStates.HunterState;
import org.l11gr05.arena.ghost.ghostStrategies.BlinkyStrategy;
import org.l11gr05.arena.ghost.ghostStrategies.ClydeStrategy;
import org.l11gr05.arena.ghost.ghostStrategies.InkyStrategy;
import org.l11gr05.arena.ghost.ghostStrategies.PinkyStrategy;

public class GhostTest {

    @Test
    public void PositionTest(){
        Blinky blinky = new Blinky(5, 10);
        Position expected = new Position(5, 10);
        Assertions.assertEquals(expected, blinky.getPosition());
    }

    @Test
    public void BlinkyStrategyTest(){
        Blinky blinky = new Blinky(10, 10);
        Assertions.assertEquals(blinky.getStrategy().getClass(), BlinkyStrategy.class);
    }

    @Test
    public void ClydeStrategyTest(){
        Clyde clyde = new Clyde(10, 10);
        Assertions.assertEquals(clyde.getStrategy().getClass(), ClydeStrategy.class);
    }

    @Test
    public void InkyStrategy(){
        Inky inky = new Inky(10, 10);
        Assertions.assertEquals(inky.getStrategy().getClass(), InkyStrategy.class);
    }

    @Test
    public void PinkyStrategy(){
        Pinky pinky = new Pinky(10, 10);
        Assertions.assertEquals(pinky.getStrategy().getClass(), PinkyStrategy.class);
    }

    @Test
    public void powerPelletHouseState(){
        Clyde clyde = new Clyde(10, 10);
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), HouseState.class);
    }

    @Test
    public void powerPelletHunterState(){
        Clyde clyde = new Clyde(10, 10);
        clyde.setState(new HunterState());
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), ChasedState.class);
    }

    @Test
    public void powerPelletChasedState(){
        Clyde clyde = new Clyde (10, 10);
        clyde.setState(new ChasedState());
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), ChasedState.class);
    }

    @Test
    public void powerPelletEatenState(){
        Clyde clyde = new Clyde(10, 10);
        clyde.setState(new EatenState());
        clyde.powerPelletEaten();
        Assertions.assertEquals(clyde.getState().getClass(), HunterState.class);
    }

    @Test
    public void pacManCollisionChasedState(){
        Inky inky = new Inky(10, 10);
        inky.setState(new ChasedState());
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), EatenState.class);
    }

    @Test
    public void pacManCollisionEatenState(){
        Inky inky = new Inky(10, 10);
        inky.setState(new EatenState());
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), EatenState.class);
    }

    @Test
    public void pacManCollisionHouseState(){
        Inky inky = new Inky(10, 10);
        inky.setState(new HouseState());
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), HouseState.class);
    }

    @Test
    public void pacManCollisionHunterState(){
        Inky inky = new Inky (10, 10);
        inky.setState(new HunterState());
        inky.pacManCollision();
        Assertions.assertEquals(inky.getState().getClass(), HunterState.class);
    }

}
