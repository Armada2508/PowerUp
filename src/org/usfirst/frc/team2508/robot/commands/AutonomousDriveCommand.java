package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command {


	double leftSpeed;
	double rightSpeed;
    public AutonomousDriveCommand(double leftSpeed, double rightSpeed) {
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSystem.drive(leftSpeed, rightSpeed);
    }


    // Called repeatedly when this Command is scheduled to run
	
    protected void execute() {
    	
    	//System.out.println("open2");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
