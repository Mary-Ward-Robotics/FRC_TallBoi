package robot.commands.operator;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class IntakeStop extends Command {

    public IntakeStop() {
    	requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.delivery.setIntakeStop();
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
