import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.classes.game.arena.ArenaFactory;
import org.l11gr05.classes.game.elements.PowerPellet;

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

        expected.add(new PowerPellet(1,18));
        expected.add(new PowerPellet(17,18));
        expected.add(new PowerPellet(1, 5));
        expected.add(new PowerPellet(17, 5));

        Assertions.assertEquals(expected, actual);
    }
}
