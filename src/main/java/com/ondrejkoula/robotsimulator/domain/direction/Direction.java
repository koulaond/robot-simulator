package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public interface Direction {
    
    Position nextStep(Position current);

    Direction turnLeft();

    Direction turnRight();
    
    
}
