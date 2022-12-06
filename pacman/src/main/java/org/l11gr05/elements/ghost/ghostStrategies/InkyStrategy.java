package org.l11gr05.elements.ghost.ghostStrategies;

import org.l11gr05.elements.Pacman;
import org.l11gr05.elements.Position;

import java.util.List;
import java.util.Random;

public class InkyStrategy implements IGhostStrategy {
    @Override
    public Position nextTargetMove(Pacman pacman, List<Position> possibles) {
        Random random = new Random();
        int temp = random.nextInt(possibles.size() - 0) + 0;
        return possibles.get(temp);
    }

    @Override
    public Position nextScatorMove(Pacman pacman, List<Position> possibles) {
        Random random = new Random();
        int temp = random.nextInt(possibles.size() - 0) + 0;
        return possibles.get(temp);
    }
}
