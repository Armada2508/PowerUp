package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousStraightCommand extends CommandGroup {
	public AutonomousStraightCommand() {
		// this is being called if this is in the console
		System.out.println("Going straight!");
		
		// sets speed to 1/10 max going forward
		addSequential(new AutonomousDriveCommand(.1, .1));
		// waits for 1 seconds
		addSequential(new WaitCommand(100));
		// stops driving
		addSequential(new AutonomousDriveCommand(0, 0));
	}
}
