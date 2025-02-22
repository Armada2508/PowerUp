/* taken from 2017 robot
 * not completely sure what slew and timeramp is
 */

package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Pair;
import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRobot extends Command {
	
	public int count = 2;
	
    public DriveRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    
    Pair rampPairThing = new Pair(0,0);

    // Called repeatedly when this Command is scheduled to run
	
    private Pair doTimeRamp(long millisPerTick, Pair pair)
    {
        double posSlewLimit = RobotMap.DriveSystemMaxSlewRate*1000/millisPerTick;
        double negSlewLimit = -posSlewLimit;
		double leftDiff = pair.left - rampPairThing.left;
        double rightDiff = pair.right - rampPairThing.right;
       
        leftDiff = Math.max(negSlewLimit, Math.min(posSlewLimit, leftDiff));
        rightDiff = Math.max(negSlewLimit, Math.min(posSlewLimit, rightDiff));
        
        rampPairThing = new Pair(rampPairThing.left + leftDiff, rampPairThing.right + rightDiff);
        
        return rampPairThing;
    }
    
    // runs constantly
    protected void execute() {
    	
		double RCalc, LCalc;
		RCalc = Robot.oi.stick.getRawAxis(1);
		LCalc = Robot.oi.stick.getRawAxis(1);
		RCalc += Robot.oi.stick.getRawAxis(4);
		LCalc -= Robot.oi.stick.getRawAxis(4);
		
		RCalc = Math.max(-1, Math.min(1, RCalc));
		LCalc = Math.max(-1, Math.min(1, LCalc));

		Pair pair = doTimeRamp(20, new Pair(LCalc,RCalc));
		
		Robot.DriveSystem.drive(-(pair.left),-(pair.right));    	
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
