
package org.usfirst.frc.team2508.robot;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2508.robot.commands.*;
import org.usfirst.frc.team2508.robot.subsystems.*;

import org.usfirst.frc.team2508.robot.Camera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveSystem DriveSystem = new DriveSystem();
	public static final CubeIntakeSystem CubeIntakeSystem = new CubeIntakeSystem();
	public static final CubeLiftSystem CubeLiftSystem = new CubeLiftSystem();
	public static OI oi;
	
	public static String switchPositions = "LRL";

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public double groundCubeHeight;
	public double driverCubeHeight;
	public double switchCubeHeight;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Left Drive Station", new AutoCodeStation1());
		chooser.addObject("Middle Drive Station", new AutoCodeMiddle());
		chooser.addObject("Right Drive Station", new AutoCodeStation3());
		chooser.addObject("Test motionmagic", new MotionMagic());
		SmartDashboard.putData("Auto mode", chooser);
		
		groundCubeHeight = SmartDashboard.getNumber("groundCubeHeight", 0.0);
		driverCubeHeight = SmartDashboard.getNumber("driverCubeHeight", 12.0);
		switchCubeHeight = SmartDashboard.getNumber("switchCubeHeight", 14.0);
		
		Camera.startStream();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		switchPositions = DriverStation.getInstance().getGameSpecificMessage();
		
		Scheduler.getInstance().run();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		SmartDashboard.putData("Auto mode", chooser);
		
		groundCubeHeight = SmartDashboard.getNumber("groundCubeHeight", 0.0);
		driverCubeHeight = SmartDashboard.getNumber("driverCubeHeight", 12.0);
		switchCubeHeight = SmartDashboard.getNumber("switchCubeHeight", 14.0);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		// starts a DriveRobot instance, handles driving in teleop
		Command driveRobotCMD = new DriveRobot();
		driveRobotCMD.start();
		
		groundCubeHeight = SmartDashboard.getNumber("groundCubeHeight", 0.0);
		driverCubeHeight = SmartDashboard.getNumber("driverCubeHeight", 12.0);
		switchCubeHeight = SmartDashboard.getNumber("switchCubeHeight", 14.0);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
