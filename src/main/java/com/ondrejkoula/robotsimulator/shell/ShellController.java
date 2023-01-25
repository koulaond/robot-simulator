package com.ondrejkoula.robotsimulator.shell;

import com.ondrejkoula.robotsimulator.domain.PlaceCommandValue;
import com.ondrejkoula.robotsimulator.service.RobotService;
import com.ondrejkoula.robotsimulator.utils.ShellCommandUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellController {

    private final RobotService robotService;

    @Autowired
    public ShellController(RobotService robotService) {
        this.robotService = robotService;
    }

    @ShellMethod(key = "PLACE")
    public void place(String value) {
        PlaceCommandValue placeCommandValue = ShellCommandUtils.parsePlaceCommandValue(value);
        robotService.placeRobot(placeCommandValue);
    }

    @ShellMethod(key = "MOVE")
    public void move() {
       robotService.moveRobot();
    }

    @ShellMethod(key = "LEFT")
    public void left() {
       robotService.turnRobotLeft();
    }

    @ShellMethod(key = "RIGHT")
    public void right() {
      robotService.turnRobotRight();
    }

    @ShellMethod(key = "REPORT")
    public String report() {
       return robotService.report().reportMessage();
    }
}
