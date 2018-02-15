package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeStation3 extends CommandGroup {
	public AutoCodeStation3()
	{
		if(Robot.switchPositions.charAt(0) == 'L')
		{
			// forward 32
			addSequential(new DriveMotionMagic(32, 32));
			// turn 90 CW
			addSequential(new DriveMotionMagic(16.3, 0));
			// forward 15
			addSequential(new DriveMotionMagic(15, 15));
			// turn 90 CCW
			addSequential(new DriveMotionMagic(0, 16.3));
			// forward 140
			addSequential(new DriveMotionMagic(140, 140));
			// turn 90 CCW
			addSequential(new DriveMotionMagic(0, 16.3));
			// forward 181.1
			addSequential(new DriveMotionMagic(181.1, 181.1));
			// turn 90 CCW
			addSequential(new DriveMotionMagic(0, 16.3));
			// forward 12
			addSequential(new DriveMotionMagic(12, 12));
			// lift cube
			//addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
			// release cube
			addSequential(new ReleaseCube());
		}
		if(Robot.switchPositions.charAt(0) == 'R')
		{
			// forward 32
			addSequential(new DriveMotionMagic(32, 32));
			// turn 90 CW
			addSequential(new DriveMotionMagic(16.3, 0));
			// forward 15
			addSequential(new DriveMotionMagic(15, 15));
			// turn 90 CCW
			addSequential(new DriveMotionMagic(0, 16.3));
			// forward 100
			addSequential(new DriveMotionMagic(100, 100));
			// turn 90 CCW
			addSequential(new DriveMotionMagic(0, 16.3));
			// forward 50.69
			addSequential(new DriveMotionMagic(50.7, 50.7));
			// lift cube
			//addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
			// release cube
			addSequential(new ReleaseCube());
		}
	}
}
