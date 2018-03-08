package org.usfirst.frc.team2508.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCodeStraight extends CommandGroup {

	public AutoCodeStraight() {
		addSequential(new DriveMotionMagic(75, 75));
	}
}
