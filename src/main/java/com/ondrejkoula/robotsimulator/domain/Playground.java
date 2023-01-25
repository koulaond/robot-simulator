package com.ondrejkoula.robotsimulator.domain;

import static java.lang.String.format;

public record Playground(int width, int height) {

    private static Playground INSTANCE;

    public void validatePosition(Position position) {
        if (position.getXPos() < 0
                || position.getYPos() < 0
                || position.getXPos() >= width
                || position.getYPos() >= height) {

            throw new IllegalStateException(format("This position %s:%s is not allowed",
                    position.getXPos(), position.getYPos()));
        }
    }

    public static Playground getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Playground(5, 5);
        }
        return INSTANCE;
    }
}
