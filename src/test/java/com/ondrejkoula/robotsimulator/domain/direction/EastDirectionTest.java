package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.speed.Run;
import com.ondrejkoula.robotsimulator.domain.speed.Walk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EastDirectionTest {

    @Test
    void nextStep_walk() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();
     
        Position nextPosition = EastDirection.getInstance().nextStep(position, new Walk());
        Assertions.assertEquals( Position.builder()
                .xPos(4)
                .yPos(3)
                .build(), nextPosition);
    }

    @Test
    void nextStep_run() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = EastDirection.getInstance().nextStep(position, new Run());
        Assertions.assertEquals( Position.builder()
                .xPos(5)
                .yPos(3)
                .build(), nextPosition);
    }

    @Test
    void turnLeft() {
        Assertions.assertEquals(NorthDirection.getInstance(), EastDirection.getInstance().turnLeft());
    }

    @Test
    void turnRight() {
        Assertions.assertEquals(SouthDirection.getInstance(), EastDirection.getInstance().turnRight());
    }
}