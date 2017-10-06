package net.agilepartner.store.robot.backend.controller;

import net.agilepartner.store.robot.backend.model.Robot;
import net.agilepartner.store.robot.backend.service.IRobotStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RestController
public class StoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private IRobotStoreService service;

    @GetMapping("/robot/{id}")
    public Robot findRobot(@PathVariable Long id) {
        return service.findRobot(id);
    }

    @GetMapping("/robot/list")
    public List<Robot> listRobot() {
        LOGGER.info("List of robots asked");
        return service.listRobot();
    }

    @DeleteMapping("/robot/{id}")
    public boolean deleteRobot(@PathVariable Long id) {
        service.deleteRobot(id);
        return true;
    }

    @PostMapping("/robot")
    public void addRobot(@RequestBody Robot robot) {
        service.addRobot(robot);
    }

    @PutMapping("/robot/{id}")
    public void updateRobot(@RequestBody Robot robot) {
        service.updateRobot(robot);
    }

}
