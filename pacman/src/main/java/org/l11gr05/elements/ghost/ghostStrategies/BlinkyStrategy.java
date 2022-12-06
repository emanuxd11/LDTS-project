package org.l11gr05.elements.ghost.ghostStrategies;
import org.l11gr05.elements.Pacman;
import org.l11gr05.elements.Position;

import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class BlinkyStrategy implements IGhostStrategy {

    @Override
    public Position nextTargetMove(Pacman pacman, List<Position> possibles) {
        Position pacmanPosition = pacman.getPosition();
        int min = 20000;
        int index = 0;
        for (int i = 1; i <= possibles.size();i++){
            Position position = possibles.get(i);
            Position comparable = new Position(abs(position.getX() - pacmanPosition.getX()),abs( position.getX() - pacmanPosition.getX()));
            int temp = comparable.getX() + comparable.getY();
            if (temp < min) {
                min = temp;
                index = i;
            }
        }
        return possibles.get(index);
    }

    @Override
    public Position nextScatorMove(Pacman pacman, List<Position> possibles) {
        Random random = new Random();
        int temp = random.nextInt(possibles.size() - 0) + 0;
        return possibles.get(temp);
    }
}
