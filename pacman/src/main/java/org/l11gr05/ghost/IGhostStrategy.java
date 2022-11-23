package org.l11gr05.ghost;

import org.l11gr05.Position;

public interface IGhostStrategy {
    public Position nextTargetMove();
    public Position nextScatorMove();
}
