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

    public void setPosition(Position position){
        this.position = position;
    }

    public List<Position> getAllNeighbours(){
        List<Position> neighbours = new ArrayList<>();
        Position right = new Position(position.getX()+1, position.getY());
        Position left = new Position(position.getX()-1, position.getY());

        neighbours.add(left);
        neighbours.add(right);
        neighbours.add(new Position(position.getX(), position.getY() + 1));
        neighbours.add(new Position(position.getX(), position.getY() - 1));


        if (right.equals(new Position(19, 10))) {
            neighbours.remove(right);
        }


        else if (left.equals(new Position(-1, 10))) {
            neighbours.remove(left);
        }

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
