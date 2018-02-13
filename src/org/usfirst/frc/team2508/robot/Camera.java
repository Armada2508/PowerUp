package org.usfirst.frc.team2508.robot;

import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
	
    public static void startStream() {
    	
         class camProp { 		
   			final static int width = 144;
        	final static int height = 100;
    	   	final static int fps = 30;
    	}
    	
	    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture("topCamera", 0);
	    
	    camera1.setResolution(camProp.width, camProp.height);
	    camera1.setFPS(camProp.fps);
	    
	    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("bottomCamera", 1);
	    
	    camera2.setResolution(camProp.width, camProp.height);
	    camera2.setFPS(camProp.fps);
	    
    }
    
 }