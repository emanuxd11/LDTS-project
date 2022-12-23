package org.l11gr05.model.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class PacmanTest {
    private Pacman pacman;

    @BeforeEach
    public void setUp() {
        pacman = new Pacman(new Position(0, 0), 'l', "src/main/resources/scores/highscore.txt");
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

    @Test
    public void readHighScoreError() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Pacman(new Position(10, 10), 'c', "error");
        });
        Assertions.assertEquals(exception.getClass(),RuntimeException.class);
    }

    @Test
    public void readHighScoreError2() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new Pacman(new Position(10, 10), 'c', "src/main/resources/scores/highscoretest.txt");
        });
        Assertions.assertEquals(NumberFormatException.class, exception.getClass());
    }

}