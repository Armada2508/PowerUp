package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;
import org.usfirst.frc.team2508.robot.commands.cube.MoveCube;
import org.usfirst.frc.team2508.robot.commands.cube.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeLeft extends CommandGroup {
	public AutoCodeLeft(String switchPosition) {
		super();
		System.out.println("left position " + switchPosition);
		if (switchPosition != null && switchPosition.length() > 0) {
			if (switchPosition.charAt(0) == 'L') {
				addParallel(new AutoLiftCode());
				// forward 32
				addSequential(new DriveMotionMagic(32, 32));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 15
				addSequential(new DriveMotionMagic(15, 15));
				// turn 90 CW
				addSequential(new DriveMotionMagic(37, 0));
				// forward 100
				addSequential(new DriveMotionMagic(85, 85));
				// turn 90 CW
				addSequential(new DriveMotionMagic(37, 0));
				addParallel(new MoveCube(RobotMap.SwitchPlacePosition));
				// forward 50.69
				addSequential(new DriveMotionMagic(26, 26)); // 68 68
				addSequential(new DriveMotionMagic(-8, -8));
				/*// lift cube
				addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
				// release cube
				addSequential(new ReleaseCube());*/
			} else if (switchPosition.charAt(0) == 'R') {
				// forward 32
				addSequential(new DriveMotionMagic(32, 32));
				// turn 90 CCW
				addSequential(new DriveMotionMagic(0, 39));
				// forward 15
				addSequential(new DriveMotionMagic(15, 15));
				// turn 90 CW
				addSequential(new DriveMotionMagic(37, 0));
				// forward 140
				addSequential(new DriveMotionMagic(140, 140));
				// turn 90 CW
				/*
				 * addSequential(new DriveMotionMagic(39, 0)); // forward 181.1
				 * addSequential(new DriveMotionMagic(181.1, 181.1)); // turn 90
				 * CW addSequential(new DriveMotionMagic(37, 0)); // forward 12
				 * addSequential(new DriveMotionMagic(12, 12)); // lift cube
				 * addSequential(new MoveCube(RobotMap.SwitchPlacePosition)); //
				 * release cube addSequential(new ReleaseCube()); // wait 1s
				 * addSequential(new WaitCommand(1)); // stop releasing cube
				 * addSequential(new StopCube()); // lower grip
				 * addSequential(new MoveCube(RobotMap.LowerPosition));
				 */
			}
		} else {
			// try to cross line
			addSequential(new DriveMotionMagic(75, 75));
			System.out.println("Error: RobotMap.switchPositions is either null or has zero length!");
		}
	}
	
	
}
