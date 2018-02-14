package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class MotionMagicTest extends Command {
	
	String gameData;
	
	public MotionMagicTest() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		requires(Robot.DriveSystem);
	}
	
	protected void initialize() {
		Robot.DriveSystem.driveMotionMagic(100, 100);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
