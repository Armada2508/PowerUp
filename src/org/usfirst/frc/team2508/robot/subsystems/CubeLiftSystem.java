package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeLiftSystem extends Subsystem {
	
	// declare talons
	public TalonSRX mainLiftTalon;
	private TalonSRX followerLiftTalon;

	// constructor
	public CubeLiftSystem(){
		
		// map talons
		mainLiftTalon = new TalonSRX(5);
		followerLiftTalon = new TalonSRX(6);
		
		// configures LLiftTalon as main talon and RLiftTalon as follower
		TalonHelper.initTalonSet(mainLiftTalon, followerLiftTalon, RobotMap.CubeLiftSystemConfig);
		
		mainLiftTalon.setInverted(true);
		followerLiftTalon.setInverted(true);
		mainLiftTalon.setSensorPhase(true);
		
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	

	public void stop() {
		mainLiftTalon.set(ControlMode.Velocity, 0);		
	}
	
	// turns motors to lift the cube
	public void liftCube() {		
		mainLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftSystemConfig.MaxRPM);
	}

	// turns motors to drop the cube
	public void lowerCube() {
		mainLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftSystemConfig.MaxRPM * -1);
	}
}
