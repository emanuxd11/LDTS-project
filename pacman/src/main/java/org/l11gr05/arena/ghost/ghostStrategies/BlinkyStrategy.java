package org.l11gr05.arena.ghost.ghostStrategies;
import org.l11gr05.arena.Position;

import java.util.List;

public class BlinkyStrategy implements IGhostStrategy {

    @Override
    public Position nextTargetMove(Position pacManPosition, List<Position> possibles) {
        int index = 0;
        int min = possibles.get(0).getX()+ possibles.get(0).getY();
        for (int i = 1; i < possibles.size();i++){
            int temp = possibles.get(i).getX()+ possibles.get(i).getY();
            if (temp > index){
                min = temp;
                index = i;
            }
        }
        return possibles.get(min);
    }

    @Override
    public Position nextScatorMove(Position pacManPosition, List<Position> possibles) {
        return null;
    }
}
