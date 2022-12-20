package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InkyStrategyTest {
    private Pacman pacman;
    private List<Position> possibles;
    private InkyStrategy inkyStrategy;
    private Position expectedNextPosition;
    private Position nextPosition;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l');
        inkyStrategy = new InkyStrategy();
        possibles = new ArrayList<>();
        possibles.add(new Position(1, 2));
        possibles.add(new Position(8, 0));
        possibles.add(new Position(0, 1));
        possibles.add(new Position(2, 2));
        possibles.add(new Position(8, 8));
    }

    @Test
    public void nextTargetMoveTest() {
        // To test if it returns a result from the possibles array
        boolean expected = true;
        Assertions.assertEquals(expected,
                possibles.contains(inkyStrategy.nextTargetMove(pacman, possibles)));

        InkyStrategy mockInkyStrategy = mock(InkyStrategy.class);

        expectedNextPosition = possibles.get(2);
        when(mockInkyStrategy.nextTargetMove(pacman, possibles)).thenReturn(expectedNextPosition);

        nextPosition = mockInkyStrategy.nextTargetMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }

    @Test
    public void nextScatorMoveTest() {
        // To test if it returns a result from the possibles array
        boolean expected = true;
        Assertions.assertEquals(expected,
                possibles.contains(inkyStrategy.nextScatorMove(pacman, possibles)));

        InkyStrategy mockInkyStrategy = mock(InkyStrategy.class);

        expectedNextPosition = possibles.get(2);
        when(mockInkyStrategy.nextScatorMove(pacman, possibles)).thenReturn(expectedNextPosition);

        nextPosition = mockInkyStrategy.nextScatorMove(pacman, possibles);
        Assertions.assertEquals(expectedNextPosition, nextPosition);
    }
}
