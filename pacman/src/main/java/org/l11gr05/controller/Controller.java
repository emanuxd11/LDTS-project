package org.l11gr05.controller;

import org.l11gr05.Game;
import org.l11gr05.gui.GUI;

import java.io.IOException;


public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

        public T getModel() {
        return model;
    }
        public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}

