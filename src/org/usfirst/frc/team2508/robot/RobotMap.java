package org.usfirst.frc.team2508.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final double DeadbandThreshold = 0.05;
	
	public static final double MaxDriveRPM = 2500;

	public static final double DriveSystemP = 0.5*1023/4096;
	public static final double DriveSystemI = 0.002*1023/4096;
	public static final double DriveSystemD = 0;
	public static final double DriveSystemF = 0;
	public static final int DriveSystemTimeoutMs = 0;
}
