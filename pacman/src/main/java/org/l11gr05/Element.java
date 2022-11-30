package org.l11gr05;

public abstract class Element {
    private Position position;

    public Element(Position position){
        this.position = position;
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
    
}
