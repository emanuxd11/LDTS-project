package org.l11gr05.Viewer;

import org.junit.jupiter.api.Test;
import org.l11gr05.gui.LanternaGUI;
import org.l11gr05.model.arena.Arena;
import org.l11gr05.model.arena.ArenaFactory;
import org.l11gr05.model.elements.*;
import org.l11gr05.viewer.game.GameViewer;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {

    @Test
    public void drawElementsTest() throws IOException {
        Pacman pacman = new Pacman(new Position(0, 0), 'l', "src/main/resources/scores/highscore.txt");
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(2, 3));
        walls.add(new Wall(5, 6));

        List<PacDot> pacDots = new ArrayList<>();
        pacDots.add(new PacDot(new Position(2, 3)));
        pacDots.add(new PacDot(new Position(5, 6)));

        List<PowerPellet> powerPellets = new ArrayList<>();
        powerPellets.add(new PowerPellet(new Position(2, 3)));
        powerPellets.add(new PowerPellet(new Position(5, 6)));

        Arena arena = mock(Arena.class);
        Mockito.when(arena.getPacman()).thenReturn(pacman);
        Mockito.when(arena.getWalls()).thenReturn(walls);
        Mockito.when(arena.getPacDots()).thenReturn(pacDots);
        Mockito.when(arena.getPowerPellets()).thenReturn(powerPellets);

        LanternaGUI gui = mock(LanternaGUI.class);
        GameViewer gameViewer = new GameViewer(arena);
        gameViewer.draw(gui);
        verify(arena, times(1)).getWalls();
        verify(arena, times(1)).getPacDots();
        verify(arena, times(1)).getPowerPellets();
        verify(arena, times(3)).getPacman();
    }


}


