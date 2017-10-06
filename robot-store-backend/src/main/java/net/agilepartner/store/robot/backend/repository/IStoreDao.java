package net.agilepartner.store.robot.backend.repository;

import net.agilepartner.store.robot.backend.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreDao extends JpaRepository<Robot, Long> {}
