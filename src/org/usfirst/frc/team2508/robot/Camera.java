package org.usfirst.frc.team2508.robot;

import edu.wpi.cscore.*;

import org.usfirst.frc.team2508.robot.RobotMap;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
	
    public static void startStream() {
    	
	    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture("topCamera", 0);
	    
	    camera1.setResolution(RobotMap.camera.width, RobotMap.camera.height);
	    camera1.setFPS(RobotMap.camera.fps);
	    
	    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("bottomCamera", 1);
	    
	    camera2.setResolution(RobotMap.camera.width, RobotMap.camera.height);
	    camera2.setFPS(RobotMap.camera.fps);
	    
    }
    
 }