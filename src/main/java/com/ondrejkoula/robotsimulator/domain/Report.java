package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import lombok.Builder;

import java.util.List;

import static java.lang.String.join;

@Builder
public record Report(String reportMessage) {

    public static Report buildReportMessage(Position position, Direction direction) {
        String reportMessage = join(",",
                List.of(position.getXPos().toString(),
                        position.getYPos().toString(),
                        direction.getCommandValue())
        );
        return Report.builder().reportMessage(reportMessage).build();
    }
}
