package org.l11gr05.model.elements.ghost.ghostStrategies;

import org.l11gr05.model.elements.Pacman;
import org.l11gr05.model.elements.Position;
import java.util.List;

public class ClydeStrategy implements IGhostStrategy {

    @Override
    public Position nextTargetMove(Pacman pacman, List<Position> possibles) {
        Position pacmanPosition = pacman.getPosition();
        double min = 1000;
        double max = 0;
        int index = 0;
        double distance = Math.abs(possibles.get(0).getX() -
                pacmanPosition.getX()) + Math.abs(possibles.get(0).getY()
                - pacmanPosition.getY());
        if (distance <= 8) {
            for (int i = 0; i < possibles.size(); i++) {
                Position position = possibles.get(i);
                distance = Math.sqrt((Math.pow((position.getX() -
                        pacmanPosition.getX()), 2) + Math.pow((position.getY()
                        - pacmanPosition.getY()), 2)));
                if (distance < min) {
                    min = distance;
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < possibles.size(); i++) {
                Position position = possibles.get(i);
                distance = Math.sqrt((Math.pow((position.getX() -
                        pacmanPosition.getX()), 2) + Math.pow((position.getY()
                        - pacmanPosition.getY()), 2)));
                if (distance > max) {
                    max = distance;
                    index = i;
                }
            }
        }

        return possibles.get(index);
    }

    @Override
    public Position nextScatorMove(Pacman pacman, List<Position> possibles) {
        Position pacmanPosition = pacman.getPosition();
        double min = 1000;
        double max = 0;
        int index = 0;
        double distance = Math.abs(possibles.get(0).getX() -
                pacmanPosition.getX()) + Math.abs(possibles.get(0).getY()
                - pacmanPosition.getY());

        if (distance <= 8) {
            for (int i = 0; i < possibles.size(); i++) {
                Position position = possibles.get(i);
                distance = Math.sqrt((Math.pow((position.getX() -
                        pacmanPosition.getX()), 2) + Math.pow((position.getY()
                        - pacmanPosition.getY()), 2)));
                if (distance > max) {
                    max = distance;
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < possibles.size(); i++) {
                Position position = possibles.get(i);
                distance = Math.sqrt((Math.pow((position.getX() -
                        pacmanPosition.getX()), 2) + Math.pow((position.getY()
                        - pacmanPosition.getY()), 2)));
                if (distance < min) {
                    min = distance;
                    index = i;
                }
            }
        }

        return possibles.get(index);
    }
}
