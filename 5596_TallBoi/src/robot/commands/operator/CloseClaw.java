package robot.commands.operator;

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
    	Robot.delivery.setIntakeClose();
    	commandDone = true;
    }

    protected boolean isFinished() {
        return commandDone;
    }
}
