package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Speed;

public interface Direction {
    
    Position nextStep(Position current, Speed speed);
    
    Position strafeLeft(Position current, Speed speed);
    
    Position strafeRight(Position current, Speed speed);

    Direction turnLeft();

    Direction turnRight();
    
    String getCommandValue();
}
