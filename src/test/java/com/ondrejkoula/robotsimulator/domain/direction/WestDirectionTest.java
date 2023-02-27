package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Run;
import com.ondrejkoula.robotsimulator.domain.speed.Walk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WestDirectionTest {

    @Test
    void nextStep_walk() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = WestDirection.getInstance().nextStep(position, new Walk());
        Assertions.assertEquals(Position.builder()
                .xPos(2)
                .yPos(3)
                .build(), nextPosition);
    }

    @Test
    void nextStep_run() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = WestDirection.getInstance().nextStep(position, new Run());
        Assertions.assertEquals(Position.builder()
                .xPos(1)
                .yPos(3)
                .build(), nextPosition);
    }

    @Test
    void turnLeft() {
        Assertions.assertEquals(SouthDirection.getInstance(), WestDirection.getInstance().turnLeft());
    }

    @Test
    void turnRight() {
        Assertions.assertEquals(NorthDirection.getInstance(), WestDirection.getInstance().turnRight());
    }
}