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
    
    private Robot currentRobot;
    
    private final List<Robot> placedRobots;
    
    public RobotService() {
        placedRobots = new ArrayList<>();
    }

    public void placeRobot(PlaceCommandValue placeCommandValue) {
        Robot newRobot = buildRobot(placeCommandValue);
        if (placedRobots.isEmpty()) {
            this.currentRobot = newRobot;
        }
        placedRobots.add(newRobot);
    }

    public void moveRobot() {
        currentRobot.move();
    }
    
    public void turnRobotLeft() {
        currentRobot.turnLeft();
    }

    public void turnRobotRight() {
        currentRobot.turnRight();
    }

    public Report report() {
        return Report.buildReportMessage(currentRobot.getPosition(), currentRobot.getDirection());
    }

    public void setActualRobot(Integer robotNum) {
        this.currentRobot = placedRobots.get(robotNum);
    }

    private Robot buildRobot(PlaceCommandValue placeCommandValue) {
        return Robot.builder()
                .position(Position.builder()
                        .xPos(placeCommandValue.x())
                        .yPos(placeCommandValue.y())
                        .build())
                .order(placedRobots.size())
                .direction(placeCommandValue.direction())
                .build();
    }
}
