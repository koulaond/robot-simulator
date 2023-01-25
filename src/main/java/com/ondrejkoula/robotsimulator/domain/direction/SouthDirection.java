package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public class SouthDirection implements Direction {

    private static SouthDirection instance;
    
    @Override
    public Position nextStep(Position current) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() - 1)
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



    public static SouthDirection getInstance() {
        if (instance == null) {
            instance = new SouthDirection();
        }
        return instance;
    }
}
