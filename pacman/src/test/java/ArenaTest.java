import org.junit.jupiter.api.Test;
import org.l11gr05.arena.Arena;
import org.l11gr05.arena.MapBuilder;

import java.io.IOException;

public class ArenaTest {

    @Test
    public void test() throws IOException {
        MapBuilder temp = new MapBuilder();
        Arena arena = temp.createArena("map.txt");
    }
}
