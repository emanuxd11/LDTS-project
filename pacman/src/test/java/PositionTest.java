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

    @Test
    public void getXTest(){
        Position t1 = new Position(1, 10);
        Assertions.assertEquals(t1.getX(), 1);
    }

    @Test
    public void getYTest(){
        Position t1 = new Position(1, 10);
        Assertions.assertEquals(t1.getY(), 10);
    }

    @Test
    public void setXTest(){
        Position t1 = new Position(1, 10);
        t1.setX(5);
        Assertions.assertEquals(t1.getX(), 5);
    }

    @Test
    public void setYTest(){
        Position t1 = new Position(1, 10);
        t1.setY(7);
        Assertions.assertEquals(t1.getY(), 7);
    }
}
