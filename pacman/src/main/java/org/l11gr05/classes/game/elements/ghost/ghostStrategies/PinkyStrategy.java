package org.l11gr05.classes.game.elements.ghost.ghostStrategies;

import org.l11gr05.classes.game.elements.Pacman;
import org.l11gr05.classes.game.elements.Position;

import java.util.List;
import java.util.Random;

public class PinkyStrategy implements IGhostStrategy {

    @Override
    public Position nextTargetMove(Pacman pacman, List<Position> possibles) {

        char direction = pacman.getDirection();
        Position left = possibles.get(0);
        Position right= possibles.get(0);
        Position up= possibles.get(0);
        Position down= possibles.get(0);
        for (int i = 1; i < possibles.size();i++){
            Position comparable = possibles.get(i);
            if (comparable.getX() > right.getX()) right = comparable;
            if (comparable.getX() < left.getX()) left = comparable;
            if (comparable.getY() > up.getY()) up = comparable;
            if (comparable.getY() < down.getY()) down = comparable;
        }

        Position position = new Position();

        switch(direction){
            case 'u' -> position = up;

            case 'd' -> position = down;

            case 'r' -> position = right;

            case 'l' -> position = left;
        }
        return position;
    }

    @Override
    public Position nextScatorMove(Pacman pacman, List<Position> possibles) {

        char direction = pacman.getDirection();
        Position left = possibles.get(0);
        Position right= possibles.get(0);
        Position up= possibles.get(0);
        Position down= possibles.get(0);


        for (int i = 1; i < possibles.size();i++){
            Position comparable = possibles.get(i);
            if (comparable.getX() > right.getX()) right = comparable;
            if (comparable.getX() < left.getX()) left = comparable;
            if (comparable.getY() > up.getY()) up = comparable;
            if (comparable.getY() < down.getY()) down = comparable;
        }

        Position position = new Position();

        switch(direction){
            case 'u' -> position = right;

            case 'd' -> position = left;

            case 'r' -> position = down;

            case 'l' -> position = up;

        }
        return position;
    }
}
