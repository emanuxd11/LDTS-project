package org.l11gr05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l11gr05.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTest {

    Menu menu;

    @BeforeEach
    public void setUp(){
        menu = new Menu();
    }

    @Test
    public void getEntriesTest(){
        List<String> expected = Arrays.asList("PLAY", "QUIT");
        Assertions.assertEquals(expected, menu.getEntries());
    }

    @Test
    public void getEntriesLenTest(){
        Assertions.assertEquals(2, menu.getEntriesLen());
    }

    @Test
    public void isSelectedTrue(){
        Assertions.assertTrue(menu.isSelected(0));
    }

    @Test
    public void isSelectedFalse(){
        Assertions.assertFalse(menu.isSelected(1));
    }

    @Test
    public void previousEntryNotExists(){
        Assertions.assertTrue(menu.isSelected(0));
        menu.previousEntry();
        Assertions.assertTrue(menu.isSelected(0));
    }
    @Test
    public void previousNextEntryExists(){
        Assertions.assertTrue(menu.isSelected(0));
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(1));
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(1));
        menu.previousEntry();
        Assertions.assertTrue(menu.isSelected(0));
    }

    @Test
    public void getEntryTest(){
        Assertions.assertEquals("PLAY", menu.getEntry(0));
    }

    @Test
    public void exitSelectedTest(){
        menu.nextEntry();
        Assertions.assertTrue(menu.exitSelected());
    }

    @Test
    public void startSelectedTest(){
        Assertions.assertTrue(menu.startSelected());
    }
}
