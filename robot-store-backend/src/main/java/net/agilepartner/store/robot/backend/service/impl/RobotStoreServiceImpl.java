package net.agilepartner.store.robot.backend.service.impl;


import net.agilepartner.store.robot.backend.repository.IStoreDao;
import net.agilepartner.store.robot.backend.model.Robot;
import net.agilepartner.store.robot.backend.service.IRobotStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RobotStoreServiceImpl implements IRobotStoreService {

    private IStoreDao repository;

    @Autowired
    public RobotStoreServiceImpl(IStoreDao repository) {
        this.repository = repository;
    }

    @Override
    public void addRobot(Robot robot) {
        repository.save(robot);
    }

    @Override
    public void deleteRobot(Long id) {
        repository.delete(id);
    }

    @Override
    public Robot findRobot(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Robot> listRobot() {
        return repository.findAll();
    }

    @Override
    public void updateRobot(Robot robot) {
        Robot originalRobot = repository.findOne(robot.getId());
        originalRobot.setName(robot.getName());
    }
}
