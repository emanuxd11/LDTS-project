package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;
import java.util.List;
import java.util.Random;

public class InkyStrategy implements IGhostStrategy {

    @Override
    public Position nextTargetMove(Pacman pacman, List<Position> possibles) {
        Random random = new Random();
        int temp = random.nextInt(possibles.size());
        return possibles.get(temp);
    }

    @Override
    public Position nextScatorMove(Pacman pacman, List<Position> possibles) {
        Random random = new Random();
        int temp = random.nextInt(possibles.size());
        return possibles.get(temp);
    }
}
