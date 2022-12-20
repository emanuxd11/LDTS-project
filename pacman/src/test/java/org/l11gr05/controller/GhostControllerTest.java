package org.l11gr05.controller;

import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.Game;
import org.l11gr05.controller.game.GhostController;
import org.l11gr05.controller.game.PacmanController;
import org.l11gr05.gui.GUI;
import org.l11gr05.gui.LanternaGUI;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.arena.ArenaFactory;
import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;
import org.l11gr05.model.elements.ghost.Blinky;
import org.l11gr05.model.elements.ghost.ghostStates.HunterState;
import org.l11gr05.model.elements.ghost.ghostStrategies.BlinkyStrategy;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class GhostControllerTest {

    private GhostController controller;
    private Arena arena;

    private GUI gui;

    private Game game;
    private KeyStroke keyStroke;

    @BeforeEach
    public void setUp() throws IOException {
        arena = new Arena();
        controller = new GhostController(arena);
        gui = mock(GUI.class);
        game = mock(Game.class);
    }

    @Test
    public void moveBlinkyTest() throws IOException {
        arena.setBlinky(new Blinky(3, 3, new BlinkyStrategy()));
        arena.getBlinky().setState(new HunterState(arena.getBlinky()));
        arena.setPacman(new Pacman(new Position(7, 6), '0', "src/main/resources/scores/highscore.txt"));
        Mockito.when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, 500);
        Assertions.assertEquals(new Position(4, 3), arena.getBlinky().getPosition());

    }
}
