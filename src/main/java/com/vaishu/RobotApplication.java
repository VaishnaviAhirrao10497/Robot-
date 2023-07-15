package com.vaishu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vaishu.controller.RobotController;
import com.vaishu.model.Robot;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);

	}

    @Bean
    public Robot robot() {
        return new Robot();
    }

}

