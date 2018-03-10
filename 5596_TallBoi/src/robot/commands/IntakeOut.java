package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class IntakeOut extends Command {

    public IntakeOut() {
        requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.delivery.setIntakeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.delivery.setIntakeStop();
    }

    
    protected void interrupted() {
    }
}
