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
	public TalonSRX LLiftTalon;
	public TalonSRX RLiftTalon;

	// constructor
	public CubeSystem(){
		
		// map talons
		LIntakeTalon = new TalonSRX(5);
		RIntakeTalon = new TalonSRX(6);
		LLiftTalon = new TalonSRX(7);
		RLiftTalon = new TalonSRX(8);
		
		// configures LLiftTalon as main talon and RLiftTalon as follower
		initTalonSet(LLiftTalon, RLiftTalon, 1);
		
		// sets right side and left side so they are opposite directions and oriented so forward = forward
		LIntakeTalon.setInverted(false);
		RIntakeTalon.setInverted(true);
		LLiftTalon.setSensorPhase(true);
		
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
	
	// turns motors to takes a cube in
	public void takeCube() {
		LIntakeTalon.set(ControlMode.Velocity, RobotMap.CubeIntakeRPM);
		RIntakeTalon.set(ControlMode.Velocity, RobotMap.CubeIntakeRPM);
		LLiftTalon.set(ControlMode.Velocity, 0);
		RLiftTalon.set(ControlMode.Velocity, 0);
	}
		
	// turns motors to releases a cube
	public void releaseCube() {
		LIntakeTalon.set(ControlMode.Velocity, RobotMap.CubeIntakeRPM * (-1));
		RIntakeTalon.set(ControlMode.Velocity, RobotMap.CubeIntakeRPM * (-1));
		LLiftTalon.set(ControlMode.Velocity, 0);
		RLiftTalon.set(ControlMode.Velocity, 0);
	}
		
	// stops motors
	public void holdCube() {
		LIntakeTalon.set(ControlMode.Velocity, 0);
		RIntakeTalon.set(ControlMode.Velocity, 0);
		LLiftTalon.set(ControlMode.Velocity, 0);
		RLiftTalon.set(ControlMode.Velocity, 0);
	}
	
	// turns motors to lift the cube
	public void liftCube() {
		LIntakeTalon.set(ControlMode.Velocity, 0);
		RIntakeTalon.set(ControlMode.Velocity, 0);
		LLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM);
		RLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM);
	}

	// turns motors to drop the cube
	public void dropCube() {
		LIntakeTalon.set(ControlMode.Velocity, 0);
		RIntakeTalon.set(ControlMode.Velocity, 0);
		LLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM * (-1));
		RLiftTalon.set(ControlMode.Velocity, RobotMap.CubeLiftRPM * (-1));
	}
}
