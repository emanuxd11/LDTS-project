package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;

import java.util.ArrayList;
import java.util.List;

public class PinkyStrategyTest {
    private Pacman pacman;
    private List<Position> possibles;
    private PinkyStrategy pinkyStrategy;
    private Position expectedNextPosition;
    private Position nextPosition;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l', "src/main/resources/scores/highscore.txt");
        pinkyStrategy = new PinkyStrategy();
        possibles = new ArrayList<>();
        possibles.add(new Position(1, 2));
        possibles.add(new Position(8, 0));
        possibles.add(new Position(0, 1));
        possibles.add(new Position(2, 2));
        possibles.add(new Position(8, 8));
    }

    @Test
    public void nextTargetMoveTest() {
        expectedNextPosition = new Position(0, 1);
        nextPosition = pinkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('u');
        expectedNextPosition = new Position(8, 8);
        nextPosition = pinkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('d');
        expectedNextPosition = new Position(8, 0);
        nextPosition = pinkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('r');
        nextPosition = pinkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('f');
        nextPosition = pinkyStrategy.nextTargetMove(pacman, possibles);
        expectedNextPosition = new Position(0, 0);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }

    @Test
    public void nextScatorMoveTest() {
        expectedNextPosition = new Position(8, 8);
        nextPosition = pinkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('u');
        expectedNextPosition = new Position(8, 0);
        nextPosition = pinkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('d');
        expectedNextPosition = new Position(0, 1);
        nextPosition = pinkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('r');
        expectedNextPosition = new Position(8, 0);
        nextPosition = pinkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);

        pacman.setDirection('f');
        nextPosition = pinkyStrategy.nextScatorMove(pacman, possibles);
        expectedNextPosition = new Position(0, 0);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }
}
