package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerCube extends Command {

    public LowerCube() {
    	requires(Robot.CubeLiftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.CubeLiftSystem.lowerCube();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int liftPos = Robot.CubeLiftSystem.mainLiftTalon.getSelectedSensorPosition(0);
		System.out.println(liftPos);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.CubeLiftSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.CubeLiftSystem.stop();
    }
}
