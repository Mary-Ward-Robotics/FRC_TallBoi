package robot.commands.operator;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class aaRemoveMeLiftDown extends Command {
	double speed;
	
    public aaRemoveMeLiftDown(double spd) {
    	speed = spd;
    	requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.delivery.setLiftDown(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.delivery.setLiftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
