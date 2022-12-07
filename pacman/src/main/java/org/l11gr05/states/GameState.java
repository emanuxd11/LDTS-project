package org.l11gr05.states;

import org.l11gr05.classes.game.arena.Arena;
import org.l11gr05.viewer.Viewer;
import org.l11gr05.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena model) {
        super(model);
    }

    @Override
    public Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }
}
