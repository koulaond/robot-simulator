package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Robot {

    private final Playground playground;

    private Position position;

    private Direction direction;

    private final Integer order;

    @Builder
    public Robot(Position position, Direction direction, Integer order) {
        this.position = position;
        this.direction = direction;
        this.order = order;
        this.playground = Playground.getInstance();
        playground.validatePosition(position);
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
