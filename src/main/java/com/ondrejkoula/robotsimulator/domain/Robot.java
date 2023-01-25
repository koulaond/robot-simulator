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
        if (!playground.validatePosition(position)) {
            throw new IllegalStateException("Cannot place robot out of the table");
        }
    }

    public void move() {
        Position nextPosition = direction.nextStep(position);
        if (playground.validatePosition(nextPosition)) {
            this.position = nextPosition;
        }


    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }
}
