package org.l11gr05.model.arena;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.arena.ArenaFactory;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.PowerPellet;
import org.l11gr05.model.elements.ghost.Blinky;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaTest {

    @Test
    public void powerPelletsTest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        List<PowerPellet> actual = arena.getPowerPellets();
        List<PowerPellet> expected = new ArrayList<PowerPellet>();

        expected.add(new PowerPellet(1,8));
        expected.add(new PowerPellet(26,8));
        expected.add(new PowerPellet(1, 23));
        expected.add(new PowerPellet(26, 23));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void wallsTest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        int expected = arena.getWalls().size();

        Assertions.assertEquals(expected, 502);
    }

    @Test
    public void pacDotTest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        int expected = arena.getPacDots().size();
        Assertions.assertEquals(expected, 240);
    }

    @Test
    public void isGhostTest() throws IOException {
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        Blinky blinky = new Blinky(10, 10);
        arena.setBlinky(blinky);
        Position position = new Position(10, 10);
        Assertions.assertTrue(arena.isGhost(position) == arena.getBlinky());

    }

    @Test
    public void powerPelletRemove()throws IOException{
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        arena.powerPelletRemove(new Position(1, 8));
        Assertions.assertEquals(3, arena.getPowerPellets().size());
    }

    @Test
    public void pacDotRemove()throws IOException{
        ArenaFactory temp = new ArenaFactory();
        Arena arena = temp.createArena("maps/map.txt");
        arena.pacDotRemove(new Position(6, 10));
        Assertions.assertEquals(239, arena.getPacDots().size());
    }
    
}
