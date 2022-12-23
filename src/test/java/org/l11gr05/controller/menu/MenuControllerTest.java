package org.l11gr05.controller.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.Game;
import org.l11gr05.controller.menu.MenuController;
import org.l11gr05.gui.GUI;
import org.l11gr05.gui.LanternaGUI;
import org.l11gr05.menu.Menu;
import org.l11gr05.states.State;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class MenuControllerTest {

    MenuController menuController;
    Game game;

    @BeforeEach
    public void setUp(){
        menuController = new MenuController(new Menu());
        game = mock(Game.class);
    }

    @Test
    public void DOWNTest() throws IOException {
        LanternaGUI.ACTION DOWN = GUI.ACTION.DOWN;
        menuController.step(game, DOWN, 500);
        Assertions.assertTrue(menuController.getModel().exitSelected());
    }

    @Test
    public void UPTest() throws IOException {
        LanternaGUI.ACTION UP = GUI.ACTION.UP;
        menuController.step(game, UP, 500);
        Assertions.assertTrue(menuController.getModel().startSelected());
    }
}
