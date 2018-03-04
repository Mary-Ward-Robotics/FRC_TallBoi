package robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import robot.Robot;

/**
 *
 */
public class OpenClaw extends TimedCommand {
	private boolean commandDone = false;

    public OpenClaw() {
    	super(1);
        requires(Robot.delivery);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.delivery.openClaw();
    }

    protected boolean isFinished() {
        return commandDone;
    }
}
