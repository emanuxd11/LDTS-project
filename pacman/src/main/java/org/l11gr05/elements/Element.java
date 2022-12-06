package org.l11gr05.elements;

public abstract class Element {
    private final Position position;

    public Element(Position position){
        this.position = position;
    }

    public Element(int x, int y){
        this.position = new Position(x, y);
    }

    public Position getPosition(){
        return this.position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = ((Element) o).getPosition();
        return this.getPosition().equals(p);
    }
}
