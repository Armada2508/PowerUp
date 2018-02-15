package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeMiddle extends CommandGroup {
	public AutoCodeMiddle()
	{
		if(Robot.switchPositions.charAt(0) == 'L')
		{
			// forward 36"
			addSequential(new DriveMotionMagic(36, 36));
			// turn 74.3 degrees CCW
			addSequential(new DriveMotionMagic(0, 26.9));
			// forward 80.342"
			addSequential(new DriveMotionMagic(81.3, 81.3));
			// turn 74.3 degrees CW
			addSequential(new DriveMotionMagic(26.4, 0));
			// forward 42"
			addSequential(new DriveMotionMagic(42, 42));
			// lift cube
			//addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
			// release cube
			addSequential(new ReleaseCube());
		}
		/*if(Robot.switchPositions.charAt(0) == 'R')
			//NOT DONE MEASUREMENTS ARE NOT THE SAME
		{
			// forward 36"
			addSequential(new DriveMotionMagic(36, 36));
			// turn 74.3 degrees CCW
			addSequential(new DriveMotionMagic(0, 26.9));
			// forward 80.342"
			addSequential(new DriveMotionMagic(81.3, 81.3));
			// turn 74.3 degrees CW
			addSequential(new DriveMotionMagic(26.4, 0));
			// forward 42"
			addSequential(new DriveMotionMagic(42, 42));
			// lift cube
			//addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
			// release cube
			addSequential(new ReleaseCube());
			addSequential(new WaitCommand(1));
		
		}*/
	}
}
