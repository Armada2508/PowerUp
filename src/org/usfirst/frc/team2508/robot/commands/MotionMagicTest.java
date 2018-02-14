package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class MotionMagicTest extends Command {
	
	String gameData;
	
	public MotionMagicTest() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		requires(Robot.DriveSystem);
		requires(Robot.CubeIntakeSystem);
		requires(Robot.CubeLiftSystem);
	}
	
	protected void initialize() {
		Robot.DriveSystem.driveMotionMagic(1, 1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
