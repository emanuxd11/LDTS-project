package org.l11gr05.states;

import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    // private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        // this.controller = getController();
    }

    /* private Controller getController() {
        return null;
    } */

    public T getModel() {
        return this.model;
    }

    private Viewer getViewer() {
        return null;
    }

    public void step(GUI gui) throws IOException {
        viewer.draw(gui);
    }
}
