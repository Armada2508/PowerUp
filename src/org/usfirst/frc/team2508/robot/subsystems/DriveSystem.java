package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	// declare talons
	public TalonSRX upperLeftTalon;
	public TalonSRX lowerLeftTalon;
	public TalonSRX upperRightTalon;
	public TalonSRX lowerRightTalon;

	// constructor
	public DriveSystem(){
		
		// map talons
		upperRightTalon = new TalonSRX(0);
		lowerRightTalon = new TalonSRX(1);
		lowerLeftTalon = new TalonSRX(3);
		upperLeftTalon = new TalonSRX(4);
		
		// configures upper talons as main talons, lower talons as followers
		initTalonSet(upperRightTalon, lowerRightTalon, 1);
		initTalonSet(lowerLeftTalon, upperLeftTalon, 2);
		
		// sets right side and left side so they are opposite directions and oriented so forward = forward
		upperRightTalon.setInverted(true);
		lowerRightTalon.setInverted(true);
		upperRightTalon.setSensorPhase(true);
		lowerLeftTalon.setSensorPhase(true);
		lowerLeftTalon.setInverted(false);
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	
	// configures a main talon and the follower talon
	public void initTalonSet(TalonSRX mainTalon, TalonSRX followerTalon, int pidIdx){
		mainTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, RobotMap.DriveSystemTimeoutMs, RobotMap.DriveSystemTimeoutMs);
		mainTalon.configNominalOutputForward(0f, RobotMap.DriveSystemTimeoutMs);
		mainTalon.configNominalOutputReverse(0f, RobotMap.DriveSystemTimeoutMs);
		mainTalon.configPeakOutputForward(+12.0f, RobotMap.DriveSystemTimeoutMs);
		mainTalon.configPeakOutputReverse(-12.0f, RobotMap.DriveSystemTimeoutMs);
		mainTalon.set(ControlMode.Velocity, 0f);
		
		mainTalon.config_kP(0, RobotMap.DriveSystemP, RobotMap.DriveSystemTimeoutMs);
		mainTalon.config_kI(0, RobotMap.DriveSystemI, RobotMap.DriveSystemTimeoutMs); 
		mainTalon.config_kD(0, RobotMap.DriveSystemD, RobotMap.DriveSystemTimeoutMs);
		mainTalon.config_kF(0, RobotMap.DriveSystemF, RobotMap.DriveSystemTimeoutMs);
		mainTalon.configClosedloopRamp(0.5, RobotMap.DriveSystemTimeoutMs);
    	
		followerTalon.set(ControlMode.Follower, 0f);
		followerTalon.follow(mainTalon);
	}
	
	// takes an L and R speed and uses the talons to drive at that speed
	public void drive(double powerL, double powerR){
		upperRightTalon.set(ControlMode.Velocity, processDeadband(powerR));
		lowerLeftTalon.set(ControlMode.Velocity, processDeadband(powerL));
	}
	
	// gives a deadzone for the input, so robot won't react to small movements
	private double processDeadband(double input){
		double output;
		
		if(Math.abs(input)< RobotMap.DeadbandThreshold){
			output = 0;
		}
		
		else {
			output = input * RobotMap.MaxDriveRPM;
		}
		return output;
	}
}
