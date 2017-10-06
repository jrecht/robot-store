package net.agilepartner.store.robot.backend.service;

import net.agilepartner.store.robot.backend.model.Robot;

import java.util.List;

public interface IRobotStoreService {

    void addRobot(Robot robot);

    void updateRobot(Robot robot);

    void deleteRobot(Long id);

    Robot findRobot(Long id);

    List<Robot> listRobot();

}
