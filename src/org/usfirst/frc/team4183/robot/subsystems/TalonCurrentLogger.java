package org.usfirst.frc.team4183.robot.subsystems;

import java.io.PrintWriter;

import com.ctre.CANTalon;

public class TalonCurrentLogger extends LoggerBase {

	private CANTalon motor;

	TalonCurrentLogger( CANTalon _motor) {
		super( "taloncurrent.txt", 20, 20.0);
		motor = _motor;		
	}

	@Override
	protected void writeLine( PrintWriter writer, long millis) {

		double current =  motor.getOutputCurrent();      
		writer.format("%6d %9.1f\n", millis, current);
	} 
}
