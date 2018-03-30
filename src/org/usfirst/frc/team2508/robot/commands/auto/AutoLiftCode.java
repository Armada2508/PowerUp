package org.usfirst.frc.team2508.robot.commands.auto;

import org.usfirst.frc.team2508.robot.RobotMap;
import org.usfirst.frc.team2508.robot.commands.cube.MoveCube;
import org.usfirst.frc.team2508.robot.commands.cube.ReleaseCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoLiftCode extends CommandGroup {

	public AutoLiftCode() {
		addSequential(new WaitCommand(12));
//		addSequential(new MoveCube(RobotMap.SwitchPlacePosition));
		addSequential(new ReleaseCube());
	}
}
