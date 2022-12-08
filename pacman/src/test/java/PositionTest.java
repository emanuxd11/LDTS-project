import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.classes.game.elements.Position;

public class PositionTest {
    private Position position1, position2;
    private boolean expected;

    @Test
    public void equals() {
        position1 = new Position(2, 5);
        position2 = new Position(5, 2);
        Assertions.assertNotEquals(position1, position2);
    }

    @Test
    public void differs() {
        position1 = new Position(2, 5);
        position2 = new Position(2, 5);
        Assertions.assertEquals(position1, position2);
    }

    @Test
    public void same() {
        position1 = new Position(2, 5);
        position2 = position1;

        Assertions.assertEquals(position1, position2);
    }
}
