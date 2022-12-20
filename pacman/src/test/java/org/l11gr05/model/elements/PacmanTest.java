package org.l11gr05.model.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PacmanTest {
    private Pacman pacman;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l');
    }

    @Test
    public void initialScoreTest() {
        Assertions.assertEquals(0, pacman.getScore());
    }

    @Test
    public void increaseScoreTest () {
        pacman.increaseScore(100);
        Assertions.assertEquals(100, pacman.getScore());
    }

    @Test
    public void highScoreTest() {
        int initialHighScore = pacman.getHighScore();

        pacman.increaseScore(initialHighScore - 100);
        Assertions.assertEquals(initialHighScore, pacman.getHighScore());

        pacman.increaseScore(200);
        Assertions.assertEquals(initialHighScore + 100, pacman.getHighScore());
    }

    /* @Test
    public void testWriteHighScore() throws IOException {
        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);
        BufferedWriter mockBufferedWriter = Mockito.mock(BufferedWriter.class);

        Mockito.when(new BufferedWriter(mockFileWriter)).thenReturn(mockBufferedWriter);
        pacman.writeHighScore(100);

        Mockito.verify(mockBufferedWriter).write("100");
        Mockito.verify(mockBufferedWriter).flush();
        Mockito.verify(mockBufferedWriter).close();
    } */
}