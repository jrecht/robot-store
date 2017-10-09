package net.agilepartner.store.robot.backend.Exception;

/**
 * The InvalidRobot exception is to be thrown when a Robot cannot be saved into DB.
 */
public class InvalidRobot extends Exception {

    public InvalidRobot(String message) {
        super(message);
    }

}
