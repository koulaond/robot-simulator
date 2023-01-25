package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public class EastDirection implements Direction {

    private static EastDirection instance;

    @Override
    public Position nextStep(Position current) {
        return Position.builder()
                .xPos(current.getXPos() + 1)
                .yPos(current.getYPos())
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

    public static EastDirection getInstance() {
        if (instance == null) {
            instance = new EastDirection();
        }
        return instance;
    }
}
