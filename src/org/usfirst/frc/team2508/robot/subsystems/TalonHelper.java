package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public final class TalonHelper {

	// only value that works
	private static final int pidIdx = 0;
	private static final int driveSystemTimeoutMs = 0;
	
	public static void initTalonSet(TalonSRX mainTalon, TalonSRX followerTalon, TalonConfig talonConfig){
		mainTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, pidIdx, driveSystemTimeoutMs);
		mainTalon.configNominalOutputForward(0f, driveSystemTimeoutMs);
		mainTalon.configNominalOutputReverse(0f, driveSystemTimeoutMs);
		mainTalon.configPeakOutputForward(+12.0f, driveSystemTimeoutMs);
		mainTalon.configPeakOutputReverse(-12.0f, driveSystemTimeoutMs);
		mainTalon.set(ControlMode.Velocity, 0f);
		
		mainTalon.config_kP(0, talonConfig.P, driveSystemTimeoutMs);
		mainTalon.config_kI(0, talonConfig.I, driveSystemTimeoutMs); 
		mainTalon.config_kD(0, talonConfig.D, driveSystemTimeoutMs);
		mainTalon.config_kF(0, talonConfig.F, driveSystemTimeoutMs);
		mainTalon.configClosedloopRamp(talonConfig.Ramp, driveSystemTimeoutMs);

		followerTalon.set(ControlMode.Follower, 0f);
		followerTalon.follow(mainTalon);
	}
}
