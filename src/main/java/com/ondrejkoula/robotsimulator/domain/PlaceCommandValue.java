package com.ondrejkoula.robotsimulator.domain;

import com.ondrejkoula.robotsimulator.domain.direction.Direction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceCommandValue {
    
    private int x, y;
    
    private Direction direction;
    
}
