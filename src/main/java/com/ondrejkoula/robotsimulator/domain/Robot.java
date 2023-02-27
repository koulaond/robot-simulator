package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import com.ondrejkoula.robotsimulator.domain.speed.Run;
import com.ondrejkoula.robotsimulator.domain.speed.Speed;
import com.ondrejkoula.robotsimulator.domain.speed.Walk;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Robot {

    private final Playground playground;

    private final Integer order;

    private Position position;

    private Direction direction;

    private Speed speed;

    @Builder
    public Robot(Position position, Direction direction, Integer order) {
        this.position = position;
        this.direction = direction;
        this.order = order;
        this.playground = Playground.getInstance();
        this.speed = new Walk();
        if (!playground.validatePosition(position)) {
            throw new IllegalStateException("Cannot place robot out of the table");
        }
    }

    public void move() {
        Position nextPosition = direction.nextStep(position, speed);
        if (playground.validatePosition(nextPosition)) {
            this.position = nextPosition;
        }
    }
    
    public void charge() {
        Speed walk = new Walk();
        Position nextPosition = direction.nextStep(position, walk);
        
        while (playground.validatePosition(nextPosition)) {
            this.position = nextPosition;
            nextPosition = direction.nextStep(position, walk);
        }
    }

    public void strafeLeft() {
        Position nextPosition = direction.strafeLeft(position, speed);
        if (playground.validatePosition(nextPosition)) {
            this.position = nextPosition;
        }
    }

    public void strafeRight() {
        Position nextPosition = direction.strafeRight(position, speed);
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

    public void setWalkSpeed() {
        this.speed = new Walk();
    }

    public void setRunSpeed() {
        this.speed = new Run();
    }
}
