package net.agilepartner.store.robot.backend.controller;

import net.agilepartner.store.robot.backend.Exception.IdNotFoundException;
import net.agilepartner.store.robot.backend.Exception.InvalidRobot;
import net.agilepartner.store.robot.backend.model.Robot;
import net.agilepartner.store.robot.backend.service.IRobotStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller exposing the robot store API as REST services.
 */
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private IRobotStoreService service;

    /**
     * Return the {@link Robot} denoted by the id parameter.
     *
     * @param id the technical id of the {@link Robot} to match
     * @return a {@link Robot}
     */
    @GetMapping("/robot/{id}")
    public ResponseEntity<Robot> findRobot(@PathVariable Long id) {
        return new ResponseEntity<>(service.findRobot(id), HttpStatus.OK);
    }

    /**
     * List the {@link Robot} available to sell.
     *
     * @return a List of {@link Robot}
     */
    @GetMapping("/robot/list")
    public ResponseEntity<List<Robot>> listRobot() {
        LOGGER.info("List of robots asked");
        return new ResponseEntity<>(service.listRobot(), HttpStatus.OK);
    }

    /**
     * Delete the {@link Robot} denoted by the id parameter.
     *
     * @param id the robot id
     * @return true if the Robot has been removed successfully
     */
    @DeleteMapping("/robot/{id}")
    public ResponseEntity deleteRobot(@PathVariable Long id) throws IdNotFoundException {
        service.deleteRobot(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    /**
     * Create a {@link Robot} into the database.
     *
     * @param robot the {@link Robot} to persist
     * @return the robot saved in DB.
     */
    @PostMapping("/robot")
    public ResponseEntity<Robot> addRobot(@RequestBody Robot robot, HttpServletResponse response) {
        try {
            Robot savedRobot = service.addRobot(robot);
            return new ResponseEntity<>(savedRobot, HttpStatus.CREATED);
        } catch (InvalidRobot ir) {
            LOGGER.warn("Could not save invalid robot");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    /**
     * Update data of the {@link Robot} denoted by the "id" path parameter
     *
     * @param robot the new data of the {@link Robot}
     */
    @PutMapping("/robot/{id}")
    public void updateRobot(@PathVariable Long id, @RequestBody Robot robot, HttpServletResponse response) {
        try {
            service.updateRobot(id, robot);
        } catch (IdNotFoundException infe) {
            LOGGER.warn(infe.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
    }

}
