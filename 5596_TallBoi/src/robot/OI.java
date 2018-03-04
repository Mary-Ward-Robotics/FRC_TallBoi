/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import robot.commands.ClimbDown;
import robot.commands.ClimbUp;
import robot.commands.CloseClaw;
import robot.commands.EngageOn;
import robot.commands.IntakeIn;
import robot.commands.IntakeOut;
import robot.commands.OpenClaw;
import robot.commands.TurboOff;
import robot.commands.TurboOn;
import robot.commands.aaRemoveMeLiftDown;
import robot.commands.aaRemoveMeLiftUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driver = new Joystick(0);
	private Joystick operator = new Joystick(1);
	
	//create joystick buttons
		private JoystickButton
			turboTrue, turboFalse;
		
		private JoystickButton 
			liftScale, liftSwitch, liftExchange, liftReset,
			climbUp, climbDown, intakeIn, intakeClose,
			climbLock, intakeEngage, intakeOut, intakeOpen;
			
	public OI() {
		//assign buttons
		liftScale    = new JoystickButton(operator, 1);
		liftSwitch   = new JoystickButton(operator, 2);
		liftExchange = new JoystickButton(operator, 3);
		liftReset    = new JoystickButton(operator, 4);
		climbUp      = new JoystickButton(operator, 5);
		climbDown    = new JoystickButton(operator, 6);
		intakeIn     = new JoystickButton(operator, 7);
		intakeClose  = new JoystickButton(operator, 8);
		climbLock    = new JoystickButton(operator, 9);
		intakeEngage = new JoystickButton(operator, 10);
		intakeOut    = new JoystickButton(operator, 11);
		intakeOpen   = new JoystickButton(operator, 12);
		
		turboTrue    = new JoystickButton(driver, 5);
		turboFalse   = new JoystickButton(driver, 6);
		
		//assign commands
		turboTrue.whenPressed(new TurboOn());
		turboFalse.whenPressed(new TurboOff());
		
		//climb control
		climbUp.whenPressed(new ClimbUp());
		climbDown.whenPressed(new ClimbDown());
		
		//delivery control
		intakeIn.whenPressed(new IntakeIn());
		intakeOut.whenPressed(new IntakeOut());
		
//		intakeOpen.whenPressed(new OpenClaw());
		intakeClose.whenPressed(new OpenClaw());
		intakeEngage.whenPressed(new EngageOn());
		
		//TODO remove me
		liftSwitch.whenPressed(new aaRemoveMeLiftUp());
		liftSwitch.whenPressed(new aaRemoveMeLiftDown());
	}
	
	public Joystick getdriver() {
		return driver;
	}
	
	public Joystick getoperator() {
		return operator;
	}
	
	public double getTurn() {
		return driver.getRawAxis(4);
	}
	
	public double getThrottle() {
		return driver.getRawAxis(1);
	}
	
	
	public boolean getClimbUp() {
		return operator.getRawButton(5);
	}
	
	public boolean getClimbDown() {
		return operator.getRawButton(6);
	}
	
	public boolean getIntakeIn() {
		return operator.getRawButton(7);
	}
	
	public boolean getIntakeOut() {
		return operator.getRawButton(11);
	}
	
	//TODO remove me
	public boolean getLiftUp() {
		return operator.getRawButton(2);
	}
	
	public boolean getLiftDown() {
		return operator.getRawButton(3);
	}
	
}