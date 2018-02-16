package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopCube extends Command {
	
	public StopCube() {
		requires(Robot.CubeIntakeSystem);
	}
	
	protected void initialize() {
		Robot.CubeIntakeSystem.stop();
	}
	
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void end() {
		Robot.CubeIntakeSystem.stop();
	}
	
	protected void interrupted() {
		Robot.CubeIntakeSystem.stop();
	}

}
