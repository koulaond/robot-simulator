package com.ondrejkoula.robotsimulator.domain.direction;

import com.ondrejkoula.robotsimulator.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EastDirectionTest {

    @Test
    void nextStep() {
        Position position = Position.builder()
                .xPos(3)
                .yPos(3)
                .build();
     
        Position nextPosition = EastDirection.getInstance().nextStep(position);
        Assertions.assertEquals( Position.builder()
                .xPos(4)
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