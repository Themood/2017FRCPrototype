package org.usfirst.frc.team4183.robot.subsystems;

import org.usfirst.frc.team4183.robot.commands.ClimbPrototypeCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClimbPrototypeSubsystem extends Subsystem {
	
	private final int MOTOR_NUM = 10;
	private CANTalon motor = new  CANTalon(MOTOR_NUM);
	private TalonCurrentLogger logger = new TalonCurrentLogger(motor);
	
	public void start() {
		logger.start();
		System.out.println("start");
	}
	
	public void execute( double drive) {
		motor.set(drive);
		double current = motor.getOutputCurrent();
		SmartDashboard.putNumber("ClimbMotorCurrent", current);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ClimbPrototypeCommand()); 
	}

}
