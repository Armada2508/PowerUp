package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoCodeStation2 extends Command {
	
	String gameData;
	
	public AutoCodeStation2() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	protected void initialize() {
		if(gameData.charAt(0) == 'L')
		{
			// forward 36"
			// turn 75.953 degrees CCW
			// forward 80.342"
			// turn 75.953 degrees CW
			// forward 42"
		}
		else
		{
			// forward 36"
			// turn 56.924 degrees CW
			// forward 35.730"
			// turn 56.924 degrees CCW
			// forward 42"
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
