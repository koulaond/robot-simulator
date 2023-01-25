package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public class WestDirection implements Direction {

    private static WestDirection instance;
    
    @Override
    public Position nextStep(Position current) {
        return Position.builder()
                .xPos(current.getXPos() - 1)
                .yPos(current.getYPos())
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

    @Override
    public String getCommandValue() {
        return "WEST";
    }
    
    public static WestDirection getInstance() {
        if (instance == null) {
            instance = new WestDirection();
        }
        return instance;
    }
}
