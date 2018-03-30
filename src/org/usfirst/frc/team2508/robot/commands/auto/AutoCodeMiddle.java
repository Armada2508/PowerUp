package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;
import org.usfirst.frc.team2508.robot.commands.cube.MoveCube;
import org.usfirst.frc.team2508.robot.commands.cube.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeMiddle extends CommandGroup {
	public AutoCodeMiddle(String switchPosition) {
		super();
		System.out.println("middle position " + switchPosition);
		if(switchPosition != null && switchPosition.length() > 0) {
			if(switchPosition.charAt(0) == 'L')
			{
				addParallel(new AutoLiftCode());
				System.out.print("Going left!\n");
				// forward 36"
				addSequential(new DriveMotionMagic(36, 36));
				// turn 74.3 degrees CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 80.342"
				addSequential(new DriveMotionMagic(77.3, 77.3));
				// turn 74.3 degrees CW
				addSequential(new DriveMotionMagic(37, 0));
				addParallel(new MoveCube(RobotMap.SwitchPlacePosition));
				// forward 42"
				addSequential(new DriveMotionMagic(64, 64));
				addSequential(new DriveMotionMagic(-8, -8));
				/*// lift cube
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());*/
			}
			else if(switchPosition.charAt(0) == 'R')
			{
				addParallel(new AutoLiftCode());
				System.out.print("Going Right\n!");
				// forward 36"
				addSequential(new DriveMotionMagic(36, 36));
				// turn 74.3 degrees CW
				addSequential(new DriveMotionMagic(37, 0));
				// forward 37.4"
				addSequential(new DriveMotionMagic(36, 36));
				// turn 74.3 degrees CCW
				addSequential(new DriveMotionMagic(0, 39));
				addParallel(new MoveCube(RobotMap.SwitchPlacePosition));
				// forward 42"
				addSequential(new DriveMotionMagic(64, 64));
				addSequential(new DriveMotionMagic(-8, -8));
				/*// lift cube
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());*/
			} else {
				// try to cross line
				addSequential(new DriveMotionMagic(75, 75));
				System.out.println("Error: switchPosition is either null or has zero length!");
}
		}
		
	}
}
