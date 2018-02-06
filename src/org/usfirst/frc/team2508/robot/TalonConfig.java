package org.usfirst.frc.team2508.robot;

public class TalonConfig {
	public TalonConfig(double p,double i,double d,double f,double ramp, double rpm, int peakOutput){
		P = p;
		I = i;
		D = d;
		F = f;
		Ramp = ramp;
		MaxRPM = rpm;
		PeakOutput = peakOutput;
	}
	
	public final double Ramp;
	public final double MaxRPM;
	public final double P;
	public final double I;
	public final double D;
	public final double F;
	public final int PeakOutput;
}