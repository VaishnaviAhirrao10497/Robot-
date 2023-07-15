package com.vaishu.model;



public class Robot implements Battery {
	private static final double MAX_WALK_DISTANCE = 7.0; // km
	private static final double LOW_BATTERY_REMAINED = 20;

	private double completeBattery;

	public Robot() {
		this.completeBattery = 100.0;
	}

	public double getRemainingCapacity() {
		return completeBattery;
	}

	public void consumePower(double power) {
		completeBattery -= power;
	}

	public boolean isLowBattery() {
		return completeBattery < LOW_BATTERY_REMAINED;
	}

	public void performTask() {
		System.out.println("Walking");
		System.out.println("Task Completed");
	}
	

}

