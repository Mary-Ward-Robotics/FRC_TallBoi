
package robot.commands.driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;


public class DriveWithJoystick extends Command {
	private int left;
	private int right;
	private Joystick driver;
	
	public DriveWithJoystick(int lStick, int rStick) {
		requires(Robot.chassis);
		left  = lStick;
		right = rStick;
		driver = Robot.oi.getdriver();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double lspeed = driver.getRawAxis(left);
		double rspeed = driver.getRawAxis(right);
		
		Robot.chassis.drive(lspeed, rspeed);
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
