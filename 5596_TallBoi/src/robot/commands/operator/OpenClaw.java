package robot.commands.operator;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class OpenClaw extends Command {
	private boolean commandDone = false;

    public OpenClaw() {
        requires(Robot.delivery);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.delivery.setIntakeOpen();
    	commandDone = true;
    }

    protected boolean isFinished() {
        return commandDone;
    }
}
