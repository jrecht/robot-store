package net.agilepartner.store.robot.backend;

import net.agilepartner.store.robot.backend.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication
public class RobotStoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotStoreBackendApplication.class, args);
	}
}
