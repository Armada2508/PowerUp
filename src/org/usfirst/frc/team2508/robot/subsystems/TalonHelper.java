package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class TalonHelper {
	public static void initTalonSet(TalonSRX mainTalon, TalonSRX followerTalon, int pidIdx){
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
		mainTalon.configClosedloopRamp(0f, RobotMap.DriveSystemTimeoutMs);
    	
		followerTalon.set(ControlMode.Follower, 0f);
		followerTalon.follow(mainTalon);
	}
}
