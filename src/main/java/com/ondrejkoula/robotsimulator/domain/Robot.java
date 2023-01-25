package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Robot {

    private final Playground playground;

    private Position position;

    private Direction direction;

    public Robot() {
        this.playground = Playground.getInstance();
    }

    public void move() {
        Position nextPosition = direction.nextStep(position);
        playground.validatePosition(nextPosition);
        this.position = nextPosition;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }
}
