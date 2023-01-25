package com.ondrejkoula.robotsimulator.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class Position {
    
    Integer xPos;
    
    Integer yPos;
}
