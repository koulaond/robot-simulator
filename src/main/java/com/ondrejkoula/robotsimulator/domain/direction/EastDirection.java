package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Speed;

public class EastDirection implements Direction {

    private static EastDirection instance;

    @Override
    public Position nextStep(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos() + speed.getValue())
                .yPos(current.getYPos())
                .build();
    }

    @Override
    public Position strafeLeft(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() + speed.getValue())
                .build();
    }

    @Override
    public Position strafeRight(Position current, Speed speed) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() - speed.getValue())
                .build();
    }

    @Override
    public Direction turnLeft() {
        return NorthDirection.getInstance();
    }

    @Override
    public Direction turnRight() {
        return SouthDirection.getInstance();
    }

    @Override
    public String getCommandValue() {
        return "EAST";
    }

    public static EastDirection getInstance() {
        if (instance == null) {
            instance = new EastDirection();
        }
        return instance;
    }
}
