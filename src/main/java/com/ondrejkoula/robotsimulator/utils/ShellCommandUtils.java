package com.ondrejkoula.robotsimulator.utils;

import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import com.ondrejkoula.robotsimulator.domain.direction.EastDirection;
import com.ondrejkoula.robotsimulator.domain.direction.NorthDirection;
import com.ondrejkoula.robotsimulator.domain.direction.SouthDirection;
import com.ondrejkoula.robotsimulator.domain.direction.WestDirection;
import org.apache.commons.lang3.StringUtils;

public final class ShellCommandUtils {

    private ShellCommandUtils() {
        throw new IllegalStateException("No instances of " + ShellCommandUtils.class.getName());
    }

    public static PlaceCommandValue parsePlaceCommandValue(String valueStr) {
        String[] valueSplit = StringUtils.split(valueStr, ",");
        validateCommandValueIsComplete(valueSplit);
        

        return PlaceCommandValue.builder()
                .x(Integer.parseInt(valueSplit[0]))
                .y(Integer.parseInt(valueSplit[1]))
                .direction(resolveDirectionFromCommand(valueSplit[2]))
                .build();
    }
    
    public static Direction resolveDirectionFromCommand(String directionCommand) {
        return switch (directionCommand) {
            case "NORTH" -> NorthDirection.getInstance();
            case "EAST" -> EastDirection.getInstance();
            case "SOUTH" -> SouthDirection.getInstance();
            case "WEST" -> WestDirection.getInstance();
            default -> throw new UnsupportedOperationException("Direction " + directionCommand + " is not supported");
        };
    }

    private static void validateCommandValueIsComplete(String[] valueSplit) {
        if (valueSplit == null || valueSplit.length != 3) {
            throw new IllegalArgumentException("Wrong argument for PLACE command.");
        }
    }
}
