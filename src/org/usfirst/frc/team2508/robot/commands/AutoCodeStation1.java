package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

public class AutoCodeStation1 extends Command {

	String gameData;
	
	public AutoCodeStation1() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	protected void initialize() {
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
