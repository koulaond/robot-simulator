package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WestDirectionTest {

    @Test
    void nextStep() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = WestDirection.getInstance().nextStep(position);
        Assertions.assertEquals( Position.builder()
                .xPos(2)
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