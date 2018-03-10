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

    protected void execute() {
    	Robot.delivery.setLiftDown(speed/2);
    }

	protected boolean isFinished() {
		return false;
	}

    protected void end() {
    	Robot.delivery.setLiftStop();
    }
}
