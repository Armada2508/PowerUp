package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	// declare talons
	private TalonSRX mainLeftTalon;
	private TalonSRX followerLeftTalon;
	private TalonSRX mainRightTalon;
	private TalonSRX followerRightTalon;

	// constructor
	public DriveSystem(){
		
		// map talons
		mainRightTalon = new TalonSRX(3); // 3 for this years, 0 for last years
		followerRightTalon = new TalonSRX(4); // 4 for this years, 1 for last years
		
		mainLeftTalon = new TalonSRX(7); // 7 for this years, 3 for last years
		followerLeftTalon = new TalonSRX(8); // 8 for this years, 4 for last years
		
		
		// configures talons as main talons and other talons as followers
		TalonHelper.initTalonSet(mainRightTalon, followerRightTalon, RobotMap.DriveSystemConfig);
		TalonHelper.initTalonSet(mainLeftTalon, followerLeftTalon, RobotMap.DriveSystemConfig);
		//mainLeftTalon.configMaxIntegralAccumulator(0, 2000, 10);
		//mainRightTalon.configMaxIntegralAccumulator(0, 2000, 10);
		
		// sets right side and left side so they are opposite directions and oriented so forward = forward
		mainRightTalon.setInverted(false); // false for this years
		followerRightTalon.setInverted(false); // false for this years
		mainRightTalon.setSensorPhase(false); // false for this years
		
		mainLeftTalon.setInverted(false);
		followerLeftTalon.setInverted(false);
		mainLeftTalon.setSensorPhase(true);
		
		mainLeftTalon.configMotionCruiseVelocity(RobotMap.MMCruiseVelocity, 0);
		mainLeftTalon.configMotionAcceleration(RobotMap.MMAcceleration, 0);
		mainRightTalon.configMotionCruiseVelocity(RobotMap.MMCruiseVelocity, 0);
		mainRightTalon.configMotionAcceleration(RobotMap.MMAcceleration, 0);
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	
	// takes an L and R speed and uses the talons to drive at that speed
	public void drive(double powerL, double powerR){
		mainRightTalon.set(ControlMode.Velocity, processDeadband(powerR));
		mainLeftTalon.set(ControlMode.Velocity, processDeadband(powerL));
	}
	
	// takes an L and R position and uses the talons in MotionMagic to drive there
	public void driveMotionMagic(double distanceL, double distanceR)
	{	
		mainRightTalon.set(ControlMode.MotionMagic, distanceR);
		mainLeftTalon.set(ControlMode.MotionMagic, distanceL);
	}
	
	public int getLeftPosition()
	{
		return mainLeftTalon.getSelectedSensorPosition(0);
	}
	
	public int getRightPosition()
	{
		return mainRightTalon.getSelectedSensorPosition(0);
	}
	
	// gives a deadzone for the input, so robot won't react to small movements
	private double processDeadband(double input){
		double output;
		
		if(Math.abs(input)< RobotMap.DeadbandThreshold){
			output = 0;
		}
		
		else {
			output = input * RobotMap.DriveSystemConfig.MaxRPM;
		}
		return output;
	}
}
