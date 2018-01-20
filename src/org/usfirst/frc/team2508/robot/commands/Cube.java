package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2508.robot.Robot;

// command that controls the cube's direction
public class Cube extends Command {
	
	private int direction;

	public Cube(int dir) {
		if(dir == -2) direction = -2; // drop cube
		if(dir == -1) direction = -1; // release cube
		if(dir == 0) direction = 0; // do nothing
		if(dir == 1) direction = 1; // take cube
		if(dir == 2) direction = 2; // lift cube
		
		requires(Robot.CubeSystem);
	}
	
	protected void initialize() {
		if(direction == -2) Robot.CubeSystem.dropCube();
		if(direction == -1) Robot.CubeSystem.releaseCube();
		if(direction == 0) Robot.CubeSystem.holdCube();
		if(direction == 1) Robot.CubeSystem.takeCube();
		if(direction == 2) Robot.CubeSystem.liftCube();
	}
	
	protected void execute() {
		
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
