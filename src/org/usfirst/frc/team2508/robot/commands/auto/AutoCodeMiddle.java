package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;
import org.usfirst.frc.team2508.robot.commands.cube.MoveCube;
import org.usfirst.frc.team2508.robot.commands.cube.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeMiddle extends CommandGroup {
	public AutoCodeMiddle()
	{
		if(RobotMap.switchPositions != null && RobotMap.switchPositions.length() > 0) {
			if(RobotMap.switchPositions.charAt(0) == 'L')
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
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());
			}
			if(RobotMap.switchPositions.charAt(0) == 'R')
			{
				// forward 36"
				addSequential(new DriveMotionMagic(36, 36));
				// turn 74.3 degrees CCW
				addSequential(new DriveMotionMagic(19.5, 0));
				// forward 80.342"
				addSequential(new DriveMotionMagic(37.4, 37.4));
				// turn 74.3 degrees CW
				addSequential(new DriveMotionMagic(0, 19.5));
				// forward 42"
				addSequential(new DriveMotionMagic(42, 42));
				// lift cube
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());
			} else {
				// try to cross line
				addSequential(new DriveMotionMagic(75, 75));
				System.out.println("Error: RobotMap.switchPositions is either null or has zero length!");
}
		}
		
	}
}
