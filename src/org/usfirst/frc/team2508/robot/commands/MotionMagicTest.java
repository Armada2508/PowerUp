package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.commands.DriveMotionMagic;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class MotionMagicTest extends Command {
	
	String gameData;
	
	public MotionMagicTest() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		requires(Robot.DriveSystem);
	}
	
	protected void initialize() {
		new DriveMotionMagic(0, 0);
		new DriveMotionMagic(20000, 20000);
		new DriveMotionMagic(0, 10000);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
