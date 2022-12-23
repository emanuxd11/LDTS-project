package org.l11gr05.controller.game;

import org.l11gr05.model.arena.Arena;
import org.l11gr05.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
