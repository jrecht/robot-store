package net.agilepartner.store.robot.backend.service;

import net.agilepartner.store.robot.backend.Exception.InvalidRobot;
import net.agilepartner.store.robot.backend.model.Robot;

import java.util.List;

/**
 * Robot store back-end service to perform CRUD operations.
 */
public interface IRobotStoreService {

    /**
     * Store a new {@link Robot} into DB.
     *
     * @param robot the {@link Robot} to persist
     * @return The Robot saved in DB.
     * @throws InvalidRobot if the robot cannot be saved into DB
     */
    Robot addRobot(Robot robot) throws InvalidRobot;

    /**
     * Update the {@link Robot}.
     *
     * @param robotId {@link Robot} id to be updated
     * @param robot   new data of a {@link Robot} to be stored
     */
    Robot updateRobot(long robotId, Robot robot);

    /**
     * Delete a {@link Robot} from the DB.
     *
     * @param id the id of the {@link Robot} to remove from DB
     */
    void deleteRobot(Long id);

    /**
     * Return the {@link Robot} matching the id parameter.
     *
     * @param id the id of the Robot
     * @return a Robot if the id exist in DB
     */
    Robot findRobot(Long id);

    /**
     * List the Robot contained in DB.
     *
     * @return a List of Robot
     */
    List<Robot> listRobot();

}
