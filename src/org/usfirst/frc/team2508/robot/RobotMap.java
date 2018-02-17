package org.usfirst.frc.team2508.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
	// stick must be moved this far to drive
	public static final double DeadbandThreshold = 0.05;

	public static final double DriveSystemMaxSlewRate = 0.01 * 1023 / 4096;

	// Drive system/PID variables
	public static final TalonConfig DriveSystemConfig = new TalonConfig(1.0 * 1023 / 4096, 0.01 * 1023 / 4096,
			0.01 * 1023 / 4096, 0, 0.1, 4000, 12, 40);
	public static final TalonConfig CubeLiftSystemConfig = new TalonConfig(1.0 * 1023 / 4096, 0.0001 * 1023 / 4096,
			0.00 * 1023 / 4096, 0, 0.0, 2500, 6, 5);

	public static final int LiftTopLimit = 14000;
	public static final double SwitchPlacePosition = 14000;
	public static final double ShootRecievePosition = 8000;
	public static final double LowerPosition = 1000; // don't make quite zero,
														// so it doesn't drive
														// it into the bottom

	// speed of the cube intake/output system
	public static final double CubeIntakePercentOutput = 1.0;
	public static final double CubeSystemTime = 0.5;

	// acceleration/velocity for motionmagic
	public static final int MMAcceleration = 1500;
	public static final int MMCruiseVelocity = 600;
	public static final int MMTolerance = 500;

	class camera {
		public final static int width = 144;
		public final static int height = 100;
		public final static int fps = 30;
	}

}