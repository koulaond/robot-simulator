package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public class WestDirection implements Direction {

    private static WestDirection instance;
    
    @Override
    public Position nextStep(Position current) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() - 1)
                .build();
    }

    @Override
    public Direction turnLeft() {
        return SouthDirection.getInstance();
    }

    @Override
    public Direction turnRight() {
        return NorthDirection.getInstance();
    }
    
    public static WestDirection getInstance() {
        if (instance == null) {
            instance = new WestDirection();
        }
        return instance;
    }
}
