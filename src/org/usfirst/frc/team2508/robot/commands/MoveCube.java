package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveCube extends Command {

	private double Position;
    public MoveCube(double position) {
    	Position = position;
    	requires(Robot.CubeLiftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.CubeLiftSystem.moveCube(Position);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(this.Position - Robot.CubeLiftSystem.getPosition()) <= 1000) return true;
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.CubeLiftSystem.stop();
    }
}
