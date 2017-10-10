package net.agilepartner.store.robot.backend.service.impl;


import net.agilepartner.store.robot.backend.Exception.IdNotFoundException;
import net.agilepartner.store.robot.backend.Exception.InvalidRobot;
import net.agilepartner.store.robot.backend.model.Robot;
import net.agilepartner.store.robot.backend.repository.IStoreDao;
import net.agilepartner.store.robot.backend.service.IRobotStoreService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the {@link IRobotStoreService}
 */
@Service
@Transactional
public class RobotStoreServiceImpl implements IRobotStoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotStoreServiceImpl.class);

    private IStoreDao repository;

    @Autowired
    public void setRepository(IStoreDao repository) {
        this.repository = repository;
    }

    /**
     * @see IRobotStoreService#addRobot(Robot)
     */
    @Override
    public Robot addRobot(Robot robot) throws InvalidRobot {
        if (StringUtils.isEmpty(robot.getName())) {
            throw new InvalidRobot("Name attribute cannot be empty");
        }
        return repository.save(robot);
    }

    /**
     * @see IRobotStoreService#deleteRobot(Long)
     */
    @Override
    public void deleteRobot(Long id) throws IdNotFoundException {
        if(!repository.exists(id)) {
            throw new IdNotFoundException("Robot id not found");
        }
        repository.delete(id);
    }

    /**
     * @see IRobotStoreService#findRobot(Long)
     */
    @Override
    public Robot findRobot(Long id) {
        return repository.findOne(id);
    }

    /**
     * @see IRobotStoreService#listRobot()
     */
    @Override
    public List<Robot> listRobot() {
        List<Robot> robotList = repository.findAll();
        if (robotList == null) {
            return Collections.emptyList();
        }
        return robotList;
    }

    /**
     * @see IRobotStoreService#updateRobot(long, Robot)
     */
    @Override
    public void updateRobot(long robotId, Robot robot) throws IdNotFoundException {
        if (repository.exists(robotId)) {
            Robot originalRobot = repository.findOne(robotId);
            originalRobot.setName(robot.getName());
        } else {
            throw new IdNotFoundException("Could not find robot to update");
        }
    }
}
