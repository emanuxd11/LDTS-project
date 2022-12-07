package org.l11gr05.classes.game.elements;

import org.l11gr05.classes.game.elements.ghost.Element;

public class Pacman extends Element {

    private char direction;
    public Pacman(Position position, char direction) {
        super(position);
        this.direction = direction;
    }

    public Pacman() {
        super(new Position(5, 5));
    }

    public char getDirection(){
        return this.direction;
    }

    public void setDirection(char a){
        this.direction = a;
    }
}
