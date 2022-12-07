package org.l11gr05.states;

import org.l11gr05.Game;
import org.l11gr05.controller.Controller;
import org.l11gr05.gui.GUI;
import org.l11gr05.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    // private final Controller<T> controller;
    private final Viewer<T> viewer;

    private final Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Controller<T> getController();


    public T getModel() {
        return this.model;
    }

    public abstract Viewer<T> getViewer();

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
