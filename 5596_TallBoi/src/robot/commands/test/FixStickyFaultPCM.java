package robot.commands.test;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class FixStickyFaultPCM extends Command {
	private static boolean commandDone = false;
    public FixStickyFaultPCM() {
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
    	Robot.technical.PCMreset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
