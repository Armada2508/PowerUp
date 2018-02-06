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

	// Drive system/PID variables
	public static final TalonConfig DriveSystemConfig = new TalonConfig(1.0*1023/4096, 0.01*1023/4096, 0.01*1023/4096, 0, 0.1, 2500);
	public static final TalonConfig CubeLiftSystemConfig = new TalonConfig(1.0*1023/4096, 0.01*1023/4096, 0.01*1023/4096, 0, 0.5, 750);
			
		
	// speed of the cube intake/output system
	public static final double CubeIntakePercentOutput = .4;
	public static final double CubeSystemTime = 0.5;
}