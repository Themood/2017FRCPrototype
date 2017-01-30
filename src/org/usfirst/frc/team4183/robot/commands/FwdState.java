package org.usfirst.frc.team4183.robot.commands;

import java.util.Set;

import org.usfirst.frc.team4183.robot.Robot;
import org.usfirst.frc.team4183.robot.subsystems.ClimbPrototypeSubsystem;
import org.usfirst.frc.team4183.utils.CommandUtils;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FwdState extends Command {
	
    public FwdState() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climbPrototypeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climbPrototypeSubsystem.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      	double drive = 1.0;
    	Robot.climbPrototypeSubsystem.on(drive);
    	System.out.println("I'm going foward at 1.0");
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if ( (timeSinceInitialized() < 1.0) && (Robot.climbPrototypeSubsystem.current() >= 40) ) {
    		return CommandUtils.stateChange( new RevState() );
    		
    	}
    	if ((timeSinceInitialized() > 1.0) && (Robot.climbPrototypeSubsystem.current() >=40) ) {
    		return CommandUtils.stateChange(new StopState() );
    		
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
