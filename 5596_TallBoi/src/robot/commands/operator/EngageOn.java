package robot.commands.operator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import robot.Robot;

/**
 *
 */
public class EngageOn extends TimedCommand {

    public EngageOn() {
    	super(1);
        requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.delivery.setEngageSpeed(0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.delivery.setEngageSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
