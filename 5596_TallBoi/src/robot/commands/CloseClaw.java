package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class CloseClaw extends Command {
	private boolean commandDone = false;

    public CloseClaw() {
        requires(Robot.delivery);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.delivery.getClawOpen() == false) {
    		commandDone = true;
    	} else {
    		Robot.delivery.closeClaw();
    		commandDone = true;
    	}
    }

    protected boolean isFinished() {
        return commandDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}