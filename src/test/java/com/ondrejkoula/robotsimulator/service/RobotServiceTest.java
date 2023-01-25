package com.ondrejkoula.robotsimulator.service;

import com.ondrejkoula.robotsimulator.RobotSimulatorApplication;
import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.domain.Report;
import com.ondrejkoula.robotsimulator.domain.direction.EastDirection;
import com.ondrejkoula.robotsimulator.domain.direction.NorthDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RobotSimulatorApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RobotServiceTest {

    @Autowired
    RobotService robotService;
    
    @Test
    void scenario1() {
        robotService.placeRobot(PlaceCommandValue.builder()
                        .x(0)
                        .y(0)
                        .direction(NorthDirection.getInstance())
                .build());
        robotService.moveRobot();
        Report report = robotService.report();
        Assertions.assertEquals("0,1,NORTH", report.reportMessage());
    }

    @Test
    void scenario2() {
        robotService.placeRobot(PlaceCommandValue.builder()
                .x(0)
                .y(0)
                .direction(NorthDirection.getInstance())
                .build());
        robotService.turnRobotLeft();
        Report report = robotService.report();
        Assertions.assertEquals("0,0,WEST", report.reportMessage());
    }

    @Test
    void scenario3() {
        robotService.placeRobot(PlaceCommandValue.builder()
                .x(1)
                .y(2)
                .direction(EastDirection.getInstance())
                .build());
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.turnRobotLeft();
        robotService.moveRobot();
        Report report = robotService.report();
        Assertions.assertEquals("3,3,NORTH", report.reportMessage());
    }

    @Test
    void scenario4_twoRobots() {
        robotService.placeRobot(PlaceCommandValue.builder()
                .x(1)
                .y(2)
                .direction(EastDirection.getInstance())
                .build());
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.turnRobotLeft();
        robotService.moveRobot();
        Report report = robotService.report();
        Assertions.assertEquals("3,3,NORTH", report.reportMessage());

        robotService.placeRobot(PlaceCommandValue.builder()
                .x(0)
                .y(0)
                .direction(NorthDirection.getInstance())
                .build());
        
        robotService.setActualRobot(1);

        robotService.moveRobot();
        report = robotService.report();
        Assertions.assertEquals("0,1,NORTH", report.reportMessage());
    }
    
    @Test
    void scenario5_movementsOutOfEdgeAreIgnored() {
        robotService.placeRobot(PlaceCommandValue.builder()
                .x(1)
                .y(2)
                .direction(EastDirection.getInstance())
                .build());
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.turnRobotLeft();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        robotService.moveRobot();
        Report report = robotService.report();
        Assertions.assertEquals("3,4,NORTH", report.reportMessage());

    }
}