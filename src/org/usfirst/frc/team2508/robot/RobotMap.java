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
	
	public static final double DriveSystemMaxSlewRate = 0.1*1023/4096;

	// Drive system/PID variables
	public static final TalonConfig DriveSystemConfig = new TalonConfig(1.0*1023/4096, 0.01*1023/4096, 0.01*1023/4096, 0, 0.1, 2500, 40);
	public static final TalonConfig CubeLiftSystemConfig = new TalonConfig(1.0*1023/4096, 0.01*1023/4096, 0.01*1023/4096, 0, 0.5, 300, 4);

	public static final double SwitchPlacePosition = 9000;
	public static final double ShootRecievePosition = 8000;
	public static final double LowerPosition = 10;	// don't make quite zero, so it doesn't drive it into the bottom
	
	// speed of the cube intake/output system
	public static final double CubeIntakePercentOutput = .4;
	public static final double CubeSystemTime = 0.5;
}