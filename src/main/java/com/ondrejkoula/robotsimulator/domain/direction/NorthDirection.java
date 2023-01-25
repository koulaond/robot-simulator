package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;

public class NorthDirection implements Direction {

    private static NorthDirection instance;
    
    @Override
    public Position nextStep(Position current) {
        return Position.builder()
                .xPos(current.getXPos())
                .yPos(current.getYPos() + 1)
                .build();
    }

    @Override
    public Direction turnLeft() {
        return WestDirection.getInstance();
    }

    @Override
    public Direction turnRight() {
        return EastDirection.getInstance();
    }


    public static NorthDirection getInstance() {
        if (instance == null) {
            instance = new NorthDirection();
        }
        return instance;
    }


}
