package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NorthDirectionTest {

    @Test
    void nextStep() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();

        Position nextPosition = NorthDirection.getInstance().nextStep(position);
        Assertions.assertEquals( Position.builder()
                .xPos(3)
                .yPos(4)
                .build(), nextPosition);
    }

    @Test
    void turnLeft() {
        Assertions.assertEquals(WestDirection.getInstance(), NorthDirection.getInstance().turnLeft());
    }

    @Test
    void turnRight() {
        Assertions.assertEquals(EastDirection.getInstance(), NorthDirection.getInstance().turnRight());
    }
}