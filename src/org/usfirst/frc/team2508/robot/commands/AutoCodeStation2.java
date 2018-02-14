package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoCodeStation2 extends Command {
	
	String gameData;
	
	public AutoCodeStation2() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		requires(Robot.DriveSystem);
		requires(Robot.CubeIntakeSystem);
		requires(Robot.CubeLiftSystem);
	}
	
	protected void initialize() {
		if(gameData.charAt(0) == 'L')
		{
			// forward 36"
			Robot.DriveSystem.driveMotionMagic(36, 36);
			// turn 75.953 degrees CCW
			// forward 80.342"
			Robot.DriveSystem.driveMotionMagic(80.3, 80.3);
			// turn 75.953 degrees CW
			// forward 42"
			Robot.DriveSystem.driveMotionMagic(42, 42);
			// lift cube
			new MoveCube(RobotMap.SwitchPlacePosition);
			// release cube
			new ReleaseCube();
			
		}
		else
		{
			// forward 36"
			Robot.DriveSystem.driveMotionMagic(36, 36);
			// turn 56.924 degrees CW
			// forward 35.730"
			Robot.DriveSystem.driveMotionMagic(35.7, 35.7);
			// turn 56.924 degrees CCW
			// forward 42"
			Robot.DriveSystem.driveMotionMagic(42, 42);
			// lift cube
			new MoveCube(RobotMap.SwitchPlacePosition);
			// release cube
			new ReleaseCube();
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
