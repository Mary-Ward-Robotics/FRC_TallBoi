package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;


public class DriveWithJoystick extends Command {
	
	public DriveWithJoystick() {
		requires(Robot.chassis);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double lspeed = Robot.oi.getLeft();
		double rspeed = Robot.oi.getRight();
		
		double leftdrive = lspeed;
		double rightdrive = rspeed;
		
		Robot.chassis.drive(leftdrive, rightdrive);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.chassis.drive(0, 0);
	}
}
