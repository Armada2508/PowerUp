package org.usfirst.frc.team2508.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// stick must be moved this far to drive
	public static final double DeadbandThreshold = 0.05;
	
	// max speed of the motors
	public static final double MaxDriveRPM = 2500;

	// Drive system/PID variables
	public static final double DriveSystemP = 0.5*1023/4096;
	public static final double DriveSystemI = 0.002*1023/4096;
	public static final double DriveSystemD = 0;
	public static final double DriveSystemF = 0;
	public static final int DriveSystemTimeoutMs = 0;
	
	// speed of the cube intake/output system
	public static final double CubeIntakeRPM = 750;
	public static final double CubeSystemTime = 0.5;
	public static final double CubeLiftRPM = 750;
}
