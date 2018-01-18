package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousStraightCommand extends CommandGroup {
	public AutonomousStraightCommand() {
		addSequential(new AutonomousDriveCommand(.1, .1));
		addSequential(new WaitCommand(10));
	}
}
