package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeStraight extends CommandGroup {

	public AutoCodeStraight() {

		System.out.println("go straight " + RobotMap.switchPositions);
		addSequential(new DriveMotionMagic(75, 75));
	}
}
