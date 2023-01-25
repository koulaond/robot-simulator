package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import lombok.Builder;

@Builder
public record PlaceCommandValue(int x, int y, Direction direction) {

}
