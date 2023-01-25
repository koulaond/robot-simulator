package com.ondrejkoula.robotsimulator.service;

import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.Robot;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    
    private Robot robot;

    public void placeRobot(PlaceCommandValue placeCommandValue) {
        robot = Robot.builder()
                .position(Position.builder()
                        .xPos(placeCommandValue.getX())
                        .yPos(placeCommandValue.getY())
                        .build())
                .direction(placeCommandValue.getDirection())
                .build();
    }
    
    public void moveRobot() {
        robot.move();
    }
    
    public void turnRobotLeft() {
        robot.turnLeft();
    }

    public void turnRobotRight() {
        robot.turnRight();
    }

    public void report() {

    }
}
