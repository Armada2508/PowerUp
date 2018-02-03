package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeSystem extends Subsystem {
	
	// declare talons
	public TalonSRX LIntakeTalon;
	public TalonSRX RIntakeTalon;
	public TalonSRX mainLiftTalon;
	public TalonSRX followerLiftTalon;

	// constructor
	public CubeSystem(){
		
		// map talons
		LIntakeTalon = new TalonSRX(1);
		RIntakeTalon = new TalonSRX(2);
		mainLiftTalon = new TalonSRX(5);
		followerLiftTalon = new TalonSRX(6);
		
		// configures LLiftTalon as main talon and RLiftTalon as follower
		TalonHelper.initTalonSet(mainLiftTalon, followerLiftTalon, 0);
		
		// sets right side and left side so they are opposite directions and oriented so forward = forward
		LIntakeTalon.setInverted(false);
		RIntakeTalon.setInverted(false);
		
		mainLiftTalon.setInverted(true);
		followerLiftTalon.setInverted(true);
		mainLiftTalon.setSensorPhase(true);
		
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	

	public void stop() {
		LIntakeTalon.set(ControlMode.Velocity, 0);
		RIntakeTalon.set(ControlMode.Velocity, 0);
		mainLiftTalon.set(ControlMode.Velocity, 0);		
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
	
	// turns motors to lift the cube
	public void liftCube() {
		mainLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM);
	}

	// turns motors to drop the cube
	public void lowerCube() {
		mainLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM * -1);
	}
}
