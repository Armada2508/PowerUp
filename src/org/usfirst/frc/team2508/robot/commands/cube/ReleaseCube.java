package org.usfirst.frc.team2508.robot.commands.cube;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseCube extends Command {

    public ReleaseCube() {
    	requires(Robot.CubeIntakeSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.CubeIntakeSystem.releaseCube();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.CubeIntakeSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.CubeIntakeSystem.stop();
    }
}
