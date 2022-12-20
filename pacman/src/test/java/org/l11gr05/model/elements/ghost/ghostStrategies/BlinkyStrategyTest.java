package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;

import java.util.ArrayList;
import java.util.List;

public class BlinkyStrategyTest {
    private Pacman pacman;
    private List<Position> possibles;
    private BlinkyStrategy blinkyStrategy;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l');
        blinkyStrategy = new BlinkyStrategy();
        possibles = new ArrayList<>();
        possibles.add(new Position(1, 2));
        possibles.add(new Position(-1, -2));
        possibles.add(new Position(0, 1));
        possibles.add(new Position(2, 2));
    }

    @Test
    public void nextTargetMoveTest() {
        // Should go as close as possible to Pacman
        Position expectedNextPosition = new Position(0, 1);
        Position nextTargetPosition = blinkyStrategy.nextTargetMove(pacman, possibles);

        Assertions.assertEquals(expectedNextPosition, nextTargetPosition);

        possibles.remove(2);
        expectedNextPosition = new Position(1, 2);
        nextTargetPosition = blinkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextTargetPosition);
    }

    @Test
    public void nextScatorMoveTest() {
        // Should go as far away as possible from Pacman
        Position expectedNextPosition = new Position(2, 2);
        Position nextTargetPosition = blinkyStrategy.nextScatorMove(pacman, possibles);

        Assertions.assertEquals(expectedNextPosition, nextTargetPosition);

        possibles.remove(3);
        expectedNextPosition = new Position(1, 2);
        nextTargetPosition = blinkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextTargetPosition);
    }
}
