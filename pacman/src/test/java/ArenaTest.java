import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.ArenaFactory;
import org.l11gr05.classes.game.elements.PowerPellet;
import org.l11gr05.classes.game.elements.ghost.Blinky;
import org.l11gr05.classes.game.elements.ghost.ghostStates.ChasedState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaTest {

    @Test
    public void powerPelletstest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("map.txt");
        List<PowerPellet> actual = arena.getPowerPellets();
        List<PowerPellet> expected = new ArrayList<PowerPellet>();

        expected.add(new PowerPellet(1,8));
        expected.add(new PowerPellet(26,8));
        expected.add(new PowerPellet(1, 23));
        expected.add(new PowerPellet(26, 23));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void wallstest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("map.txt");
        int expected = arena.getWalls().size();

        Assertions.assertEquals(expected, 502);
    }

    @Test
    public void pacDottest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("map.txt");
        int expected = arena.getPacDots().size();
        Assertions.assertEquals(expected, 240);
    }
    
}
