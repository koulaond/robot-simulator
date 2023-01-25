package com.ondrejkoula.robotsimulator.domain;

public record Playground(int width, int height) {

    private static Playground INSTANCE;

    public boolean validatePosition(Position position) {
        return position.getXPos() >= 0
                && position.getYPos() >= 0
                && position.getXPos() < width
                && position.getYPos() < height;
    }

    public static Playground getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Playground(5, 5);
        }
        return INSTANCE;
    }
}
