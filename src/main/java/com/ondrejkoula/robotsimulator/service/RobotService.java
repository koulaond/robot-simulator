package com.ondrejkoula.robotsimulator.service;

import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.domain.Position;
import com.ondrejkoula.robotsimulator.domain.Report;
import com.ondrejkoula.robotsimulator.domain.Robot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotService {
    
    private Robot robot;
    
    private final List<Robot> placedRobots;
    
    public RobotService() {
        placedRobots = new ArrayList<>();
    }

    public void placeRobot(PlaceCommandValue placeCommandValue) {
        Robot newRobot = buildRobot(placeCommandValue);
        if (placedRobots.isEmpty()) {
            this.robot = newRobot;
        }
        placedRobots.add(newRobot);
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

    public Report report() {
        return Report.buildReportMessage(robot.getPosition(), robot.getDirection());
    }

    public void setActualRobot(Integer robotNum) {
        this.robot = placedRobots.get(robotNum);
    }

    private Robot buildRobot(PlaceCommandValue placeCommandValue) {
        return Robot.builder()
                .position(Position.builder()
                        .xPos(placeCommandValue.getX())
                        .yPos(placeCommandValue.getY())
                        .build())
                .order(placedRobots.size())
                .direction(placeCommandValue.getDirection())
                .build();
    }
}
