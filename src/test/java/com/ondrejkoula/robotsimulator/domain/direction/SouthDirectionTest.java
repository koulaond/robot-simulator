package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SouthDirectionTest {

    @Test
    void nextStep() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = SouthDirection.getInstance().nextStep(position);
        Assertions.assertEquals( Position.builder()
                .xPos(3)
                .yPos(2)
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