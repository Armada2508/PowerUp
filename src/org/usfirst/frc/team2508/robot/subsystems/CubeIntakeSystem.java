package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeIntakeSystem extends Subsystem {
	
	// declare talons
	private TalonSRX LIntakeTalon;
	private TalonSRX RIntakeTalon;

	// constructor
	public CubeIntakeSystem(){
		
		// map talons
		LIntakeTalon = new TalonSRX(1);
		RIntakeTalon = new TalonSRX(2);
		
		// sets right side and left side so they are opposite directions and oriented so forward = forward
		LIntakeTalon.setInverted(false);
		RIntakeTalon.setInverted(false);		
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	

	public void stop() {
		LIntakeTalon.set(ControlMode.Velocity, 0);
		RIntakeTalon.set(ControlMode.Velocity, 0);	
	}
	
	// turns motors to takes a cube in
	public void grabCube() {
		LIntakeTalon.set(ControlMode.PercentOutput, RobotMap.CubeIntakePercentOutput);
		RIntakeTalon.set(ControlMode.PercentOutput, RobotMap.CubeIntakePercentOutput);

	}
		
	// turns motors to releases a cube
	public void releaseCube() {
		LIntakeTalon.set(ControlMode.PercentOutput, RobotMap.CubeIntakePercentOutput * -1);
		RIntakeTalon.set(ControlMode.PercentOutput, RobotMap.CubeIntakePercentOutput * -1);

	}
}
