package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeManager extends Command {

    public CubeManager() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.CubeSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// if X is pressed, start intake
    	Robot.oi.x.whenPressed(new Cube(1));
    	// if X is released, stop intake
    	Robot.oi.x.whenReleased(new Cube(0));
    	
    	// if B is pressed, start releasing
    	Robot.oi.b.whenPressed(new Cube(-1));
    	// if B is released, stop releasing
    	Robot.oi.b.whenReleased(new Cube(0));
    	
    	// if Y is pressed, start lifting
    	Robot.oi.y.whenPressed(new Cube(2));
    	// if Y is released, stop lifting
    	Robot.oi.y.whenReleased(new Cube(0));
    	
    	// if A is pressed, start dropping
    	Robot.oi.a.whenPressed(new Cube(-2));
    	// if A is released, stop dropping
    	Robot.oi.a.whenReleased(new Cube(0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
}
