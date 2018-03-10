package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class LiftManual extends Command {
double speed;
	
    public LiftManual(double spd) {
    	speed = spd;
    	requires(Robot.delivery);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.delivery.setLiftDown(speed/2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.getLiftManual();
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
