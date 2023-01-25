package com.ondrejkoula.robotsimulator.utils;

import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.domain.direction.WestDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShellCommandUtilsTest {

    @Test
    void parsePlaceCommandValue() {

        PlaceCommandValue placeCommandValue = ShellCommandUtils.parsePlaceCommandValue("0,0,WEST");

        Assertions.assertEquals(PlaceCommandValue
                        .builder()
                        .x(0)
                        .y(0)
                        .direction(WestDirection.getInstance()).build(),
                placeCommandValue);
    }
}