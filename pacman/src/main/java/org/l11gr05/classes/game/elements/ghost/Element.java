package org.l11gr05.classes.game.elements.ghost;

import org.l11gr05.classes.game.elements.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    protected Position position;

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

    public void setPosition(Position position){
        this.position = position;
    }

    public List<Position> getAllNeighbours(){
        List<Position> neighbours = new ArrayList<>();
        neighbours.add(new Position(position.getX()+1, position.getY()));
        neighbours.add(new Position(position.getX()-1, position.getY()));
        neighbours.add(new Position(position.getX(), position.getY()+1));
        neighbours.add(new Position(position.getX(), position.getY()-1));
        return neighbours;
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
