package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Speed;

public class WestDirection implements Direction {

    private static WestDirection instance;
    
    @Override
    public Position nextStep(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos() - speed.getValue())
                .yPos(current.getYPos())
                .build();
    }

    @Override
    public Position strafeLeft(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() - speed.getValue())
                .build();
    }

    @Override
    public Position strafeRight(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() + speed.getValue())
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
