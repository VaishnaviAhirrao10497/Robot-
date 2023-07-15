package com.vaishu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaishu.model.Robot;

@RestController
public class RobotController {
	private final Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    @GetMapping("/input")
    public String getInputPage() {
        return "<html>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/output\">\n" +
                "Robot walked (in Km.): <input type=\"text\" name=\"walked\"><br>\n" +
                "CarryingWeight (in Kg.): <input type=\"text\" name=\"weight\"><br>\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping("/output")
    public String getOutputPage(@RequestParam double walked, @RequestParam double weight) {
        String message = "";

        // Calculate power consumption based on walked distance and weight
        double powerConsumption = walked + (weight * 0.03);

        // Check if the weight is overweight
        if (weight > 15) {
            message = "OVER WEIGHT\n";
        }

        // Check if the remaining battery is low
        if (robot.isLowBattery()) {
            message += "LOW BATTERY";
        }

        // Consume power from the robot's battery
        robot.consumePower(powerConsumption);

        return "<html>\n" +
                "<body>\n" +
                "Robot Battery Balance: " + robot.getRemainingCapacity() + "%<br>\n" +
                message +
                "</body>\n" +
                "</html>";
    }
}



