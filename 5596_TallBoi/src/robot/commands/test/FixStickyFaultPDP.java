package robot.commands.test;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class FixStickyFaultPDP extends Command {
	private static boolean commandDone = false;
    public FixStickyFaultPDP() {
        requires(Robot.technical);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	commandDone = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return commandDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.technical.PDPreset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
