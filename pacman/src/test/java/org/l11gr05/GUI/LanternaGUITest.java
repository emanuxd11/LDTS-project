package org.l11gr05.GUI;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.gui.GUI;
import org.l11gr05.gui.LanternaGUI;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class LanternaGUITest {

    LanternaGUI gui;
    KeyStroke keyStroke = mock(KeyStroke.class);
    Screen screen;
    @BeforeEach
    public void setUp(){
        screen = mock(Screen.class);
        gui = new LanternaGUI(screen);
    }


    @Test
    public void getNextActionTestEOF() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.QUIT;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestNull() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(null);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.NONE;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestCharacter() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('q');

        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.QUIT;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestArrowUp() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.UP;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestArrowDown() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.DOWN;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestRight() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.RIGHT;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestLeft() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.LEFT;
        Assertions.assertEquals(expected, gui.getNextAction());
    }

    @Test
    public void getNextActionTestEnter() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);
        GUI.ACTION expected = GUI.ACTION.SELECT;
        Assertions.assertEquals(expected, gui.getNextAction());
    }
}
