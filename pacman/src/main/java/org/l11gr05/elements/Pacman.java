package org.l11gr05.elements;
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
}
