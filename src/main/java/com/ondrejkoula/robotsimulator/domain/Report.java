package com.ondrejkoula.robotsimulator.domain;

import lombok.Builder;

import java.util.List;

import static java.lang.String.join;

@Builder
public record Report(String reportMessage) {

    public static Report buildReportMessage(Robot robot) {
        String reportMessage = join(",",
                List.of(robot.getPosition().getXPos().toString(),
                        robot.getPosition().getYPos().toString(),
                        robot.getDirection().getCommandValue(),
                        "speed: " + robot.getSpeed().getValue().toString())
        );
        return Report.builder().reportMessage(reportMessage).build();
    }
}
