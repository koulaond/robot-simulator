package com.ondrejkoula.robotsimulator.domain;

import static java.lang.String.format;

public class Playground {

    private static Playground INSTANCE;

    private final int width;

    private final int height;

    private Playground(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void validatePosition(Position position) {
        if (position.getXPos() < 0
                || position.getYPos() < 0
                || position.getXPos() >= width
                || position.getYPos() >= height) {
            throw new IllegalStateException(format("This position %s:%s is not allowed"));
        }
    }

    public static Playground getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Playground(5, 5);
        }
        return INSTANCE;
    }
}
