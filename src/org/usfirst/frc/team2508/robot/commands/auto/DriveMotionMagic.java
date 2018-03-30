package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveMotionMagic extends Command {
	
	private double distanceL;
	private double distanceR;
	private double targetL;
	private double targetR;
	private long initializeTime = 0;
	
	public DriveMotionMagic(double dL, double dR)
	{
		this.distanceL = dL * 4096 / (6 * Math.PI);
		this.distanceR = dR * 4096 / (6 * Math.PI);
		
		requires(Robot.DriveSystem);
	}
	
	protected void initialize()
	{
		targetL = distanceL + Robot.DriveSystem.getLeftPosition();
		targetR = distanceR + Robot.DriveSystem.getRightPosition();
		
		Robot.DriveSystem.driveMotionMagic(targetL, targetR);
		initializeTime = System.currentTimeMillis();
	}

	protected boolean isFinished() {
		int currentPositionL, currentPositionR;
		
		currentPositionL = Robot.DriveSystem.getLeftPosition();
		currentPositionR = Robot.DriveSystem.getRightPosition();
		
		Boolean doneOnDistance = Math.abs(currentPositionL - targetL) <= RobotMap.MMTolerance && Math.abs(currentPositionR - targetR) <= RobotMap.MMTolerance;
		Boolean doneOnTime = initializeTime != 0 && System.currentTimeMillis() - initializeTime > RobotMap.MMTimeoutMillis;
		
		return doneOnDistance || doneOnTime;
	}
	
	protected void interrupted()
	{
		Robot.DriveSystem.drive(0, 0);
	}
	
	protected void end()
	{
		interrupted();
	}

}
