package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class IntakeIn extends Command {

    public IntakeIn() {
        requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.delivery.setIntakeIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.getIntakeIn();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.delivery.setIntakeStop();
    }

    
    protected void interrupted() {
    }
}
