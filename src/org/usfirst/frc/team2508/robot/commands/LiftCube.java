package org.usfirst.frc.team2508.robot.commands;

import java.text.MessageFormat;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCube extends Command {

    public LiftCube() {
    	requires(Robot.CubeLiftSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.CubeLiftSystem.liftCube();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int liftPos = Robot.CubeLiftSystem.mainLiftTalon.getSelectedSensorPosition(0);
    	int target = Robot.CubeLiftSystem.mainLiftTalon.getClosedLoopTarget(0);
    	int LoopError = Robot.CubeLiftSystem.mainLiftTalon.getClosedLoopError(0);
    	double outputPercent = Robot.CubeLiftSystem.mainLiftTalon.getMotorOutputPercent();
    	double outputVoltage = Robot.CubeLiftSystem.mainLiftTalon.getMotorOutputVoltage();
    	double outputCurrent = Robot.CubeLiftSystem.mainLiftTalon.getOutputCurrent();
		System.out.println(MessageFormat.format("liftPos {0} target {5} LoopError {1} percent {2} voltage {3} current {4}", liftPos, LoopError, 
				outputPercent, outputVoltage, outputCurrent, target));
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
