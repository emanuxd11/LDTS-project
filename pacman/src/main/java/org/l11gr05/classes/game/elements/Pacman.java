package org.l11gr05.classes.game.elements;

import org.l11gr05.classes.game.elements.ghost.Element;

public class Pacman extends Element {
    private char direction;
    private int score;
    public Pacman(Position position, char direction) {
        super(position);
        this.direction = direction;
        this.score = 0;
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

    public int getScore() {
        return this.score;
    }

    public void increaseScorePowerPellet() {
        this.score += 50;
    }

    public void increaseScorePacDot() {
        this.score += 10;
    }

    // meti só estes por agora, ver aqui https://pacman.fandom.com/wiki/Point_Configurations para mais
}
