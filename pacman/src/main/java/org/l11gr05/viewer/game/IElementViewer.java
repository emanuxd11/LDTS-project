package org.l11gr05.viewer.game;

import org.l11gr05.classes.game.elements.ghost.Element;
import org.l11gr05.gui.GUI;

public interface IElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
