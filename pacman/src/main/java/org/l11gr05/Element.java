package org.l11gr05;

public abstract class Element {
    private Position position;

    public Element(Position position){
        this.position = position;
    }

    public Element(int x, int y){
        this.position = new Position(x, y);
    }

    public void moveUp(){
        position.setY(this.position.getY()+1);
    }

    public void moveDown(){
        position.setY(this.position.getY()-1);
    }

    public void moveRight(){
        position.setX(this.position.getX()+1);
    }

    public void moveLeft(){
        position.setY(this.position.getY()-1);
    }

    public Position getPosition() {
        return this.position;
    }
}
