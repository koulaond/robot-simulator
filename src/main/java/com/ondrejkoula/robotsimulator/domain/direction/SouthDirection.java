package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Speed;

public class SouthDirection implements Direction {

    private static SouthDirection instance;
    
    @Override
    public Position nextStep(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() - speed.getValue())
                .build();
    }

    @Override
    public Position strafeLeft(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos() + speed.getValue())
                .yPos(current.getYPos())
                .build();
    }

    @Override
    public Position strafeRight(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos() - speed.getValue())
                .yPos(current.getYPos())
                .build();
    }

    @Override
    public Direction turnLeft() {
        return EastDirection.getInstance();
    }

    @Override
    public Direction turnRight() {
        return WestDirection.getInstance();
    }
    @Override
    public String getCommandValue() {
        return "SOUTH";
    }


    public static SouthDirection getInstance() {
        if (instance == null) {
            instance = new SouthDirection();
        }
        return instance;
    }
}
