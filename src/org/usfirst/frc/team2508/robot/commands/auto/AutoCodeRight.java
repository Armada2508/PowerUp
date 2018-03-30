package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;
import org.usfirst.frc.team2508.robot.commands.cube.MoveCube;
import org.usfirst.frc.team2508.robot.commands.cube.ReleaseCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeRight extends CommandGroup {
	public AutoCodeRight(String switchPosition)
	{
		super();
		System.out.println("right position " + switchPosition);
		if(switchPosition != null && switchPosition.length() > 0) {
			if(switchPosition.charAt(0) == 'L')
			{
				// forward 32
				addSequential(new DriveMotionMagic(32, 32));
				// turn 90 CW
				addSequential(new DriveMotionMagic(37, 0));
				// forward 15
				addSequential(new DriveMotionMagic(15, 15));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 140
				addSequential(new DriveMotionMagic(140, 140));
				/*// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 181.1
				addSequential(new DriveMotionMagic(181.1, 181.1));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 12
				addSequential(new DriveMotionMagic(12, 12));
				// lift cube
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());
				*/
			}
			else if(switchPosition.charAt(0) == 'R')
			{
				addParallel(new AutoLiftCode());
				// forward 32
				addSequential(new DriveMotionMagic(32, 32));
				// turn 90 CW
				addSequential(new DriveMotionMagic(37, 0));
				// forward 15
				addSequential(new DriveMotionMagic(15, 15));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 100
				addSequential(new DriveMotionMagic(95, 95));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				addParallel(new MoveCube(RobotMap.SwitchPlacePosition));
				// forward 50.69
				addSequential(new DriveMotionMagic(24, 24)); // 68 68
				addSequential(new DriveMotionMagic(-8, -8));
				/*// lift cube
				this.addParallel(new MoveCube(RobotMap.SwitchPlacePosition));
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube()); */
			} else {
				// try to cross line
				addSequential(new DriveMotionMagic(75, 75));
				System.out.println("Error: switchPosition is either null or has zero length!");
}
		}
	}
}
