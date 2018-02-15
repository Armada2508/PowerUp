package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MotionMagic extends CommandGroup {
	public MotionMagic()
	{
		addSequential(new DriveMotionMagic(10000, 10000));
		System.out.println("Traveled 10000 forward");
		addSequential(new DriveMotionMagic(5000, 0));
		System.out.println("Turned");
		addSequential(new DriveMotionMagic(5000, 5000));
		addSequential(new DriveMotionMagic(0, 5000));
		addSequential(new DriveMotionMagic(10000, 10000));
	}
}
