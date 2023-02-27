package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Run;
import com.ondrejkoula.robotsimulator.domain.speed.Walk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SouthDirectionTest {

    @Test
    void nextStep_walk() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = SouthDirection.getInstance().nextStep(position, new Walk());
        Assertions.assertEquals(Position.builder()
                .xPos(3)
                .yPos(2)
                .build(), nextPosition);
    }

    @Test
    void nextStep_run() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = SouthDirection.getInstance().nextStep(position, new Run());
        Assertions.assertEquals(Position.builder()
                .xPos(3)
                .yPos(1)
                .build(), nextPosition);
    }

    @Test
    void turnLeft() {
        Assertions.assertEquals(EastDirection.getInstance(), SouthDirection.getInstance().turnLeft());
    }

    @Test
    void turnRight() {
        Assertions.assertEquals(WestDirection.getInstance(), SouthDirection.getInstance().turnRight());
    }
}