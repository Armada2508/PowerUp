package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	public TalonSRX upperLeftTalon;
	public TalonSRX lowerLeftTalon;
	public TalonSRX upperRightTalon;
	public TalonSRX lowerRightTalon;

	public DriveSystem(){
		upperLeftTalon = new TalonSRX(0);
		lowerLeftTalon = new TalonSRX(1);
		upperRightTalon = new TalonSRX(3);
		lowerRightTalon = new TalonSRX(4);
		
		initTalonSet(upperLeftTalon, lowerLeftTalon, 1);
		initTalonSet(upperRightTalon, lowerRightTalon, 2);
		
		upperRightTalon.setInverted(true);
		upperLeftTalon.setSensorPhase(true);
		upperLeftTalon.setInverted(false);
		upperRightTalon.setSensorPhase(false);
	}
	
	@Override
	protected void initDefaultCommand() {

	}
	
	public void initTalonSet(TalonSRX mainTalon, TalonSRX followerTalon, int pidIdx){
		mainTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, pidIdx, RobotMap.DriveSystemTimeoutMs);
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
	
	public void drive(double powerL, double powerR){
		upperLeftTalon.set(ControlMode.Velocity, processDeadband(powerL));
		upperRightTalon.set(ControlMode.Velocity, processDeadband(powerR));
	}
	
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
