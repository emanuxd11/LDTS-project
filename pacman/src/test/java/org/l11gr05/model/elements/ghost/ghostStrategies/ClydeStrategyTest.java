package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;

import java.util.ArrayList;
import java.util.List;

public class ClydeStrategyTest {
    private Pacman pacman;
    private List<Position> possibles;
    private ClydeStrategy clydeStrategy;
    private Position expectedNextPosition;
    private Position nextPosition;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l');
        clydeStrategy = new ClydeStrategy();
        possibles = new ArrayList<>();
        possibles.add(new Position(1, 2));
        possibles.add(new Position(8, 0));
        possibles.add(new Position(0, 1));
        possibles.add(new Position(2, 2));
        possibles.add(new Position(8, 8));
    }

    @Test
    public void nextTargetMovePersecutingTest() {
        // when distance is less than 8
        expectedNextPosition = new Position(0, 1);
        nextPosition = clydeStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        // when distance is equal to 8
        possibles.remove(0);
        nextPosition = clydeStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }

    @Test
    public void nextTargetMoveWanderingTest() {
        // when distance is greater than 8
        expectedNextPosition = new Position(8, 8);
        possibles.set(0, new Position(8, 7));
        nextPosition = clydeStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }

    @Test
    public void nextScatorMoveCloseTest() {
        // when distance is less than 8
        // goes as far away as possible from Pacman
        expectedNextPosition = new Position(8, 8);
        nextPosition = clydeStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        // when distance is equal to 8
        possibles.remove(0);
        nextPosition = clydeStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }

    @Test
    public void nextScatorMoveFarAwayTest() {
        // when distance is greater than 8
        // goes as close as possible to Pacman
        possibles.set(0, new Position(8, 8));
        expectedNextPosition = new Position(0, 1);
        nextPosition = clydeStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }
}
