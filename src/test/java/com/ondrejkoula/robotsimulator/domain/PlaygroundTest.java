package com.ondrejkoula.robotsimulator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Test
    void validatePosition_shouldBeValid() {
        Playground playground = Playground.getInstance();
        playground.validatePosition(Position.builder().xPos(0).yPos(0).build());
    }

    @Test
    void validatePosition_positionIsOutOfX() {
        Playground playground = Playground.getInstance();
        Assertions.assertFalse(playground.validatePosition(Position.builder().xPos(5).yPos(0).build()));
    }

    @Test
    void validatePosition_positionIsOutOfY() {
        Playground playground = Playground.getInstance();
        Assertions.assertFalse(playground.validatePosition(Position.builder().xPos(0).yPos(5).build()));
    }

    @Test
    void validatePosition_positionIsUnderX() {
        Playground playground = Playground.getInstance();
        Assertions.assertFalse(playground.validatePosition(Position.builder().xPos(-1).yPos(0).build()));
    }

    @Test
    void validatePosition_positionIsUnderY() {
        Playground playground = Playground.getInstance();
        Assertions.assertFalse(playground.validatePosition(Position.builder().xPos(0).yPos(-1).build()));
    }
}