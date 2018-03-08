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
import robot.commands.LiftManual;
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
	private Joystick driver = new Joystick(RobotMap.DRIVER);
	private Joystick operator = new Joystick(RobotMap.OPERATOR);
	private Joystick manual = new Joystick(RobotMap.MANUAL);
	
	//create joystick buttons
		private int
			//operator buttons
			O_BT1 = 1, O_BT2 = 2, O_BT3 = 3, O_BT4 = 4, O_BT5 = 5, O_BT6 = 6,
			O_BT7 = 7, O_BT8 = 8, O_BT9 = 9, O_BT10 = 10, O_BT11 = 11, O_BT12 = 12,
			
			//driver buttons
			D_LOW = 4, D_HIGH = 5,
			//driver sticks
			D_THROTTLE = 1, D_TURN = 4,
			
			//manual button
			M_SAFETY = 0,
			//manual stick
			M_STICK = 1;
		private JoystickButton
			turboTrue, turboFalse;
		
		private JoystickButton 
			liftScale, liftSwitch, liftExchange, liftReset,
			climbUp, climbDown, intakeIn, intakeClose,
			intakeEngage, intakeOut, intakeOpen,
			
			manualSafety;

	public OI() {
		//assign buttons
		liftScale    = new JoystickButton(operator, O_BT1);
		liftSwitch   = new JoystickButton(operator, O_BT2);
		liftExchange = new JoystickButton(operator, O_BT3);
		liftReset    = new JoystickButton(operator, O_BT4);
		climbUp      = new JoystickButton(operator, O_BT5);
		climbDown    = new JoystickButton(operator, O_BT6);
		intakeIn     = new JoystickButton(operator, O_BT7);
		intakeClose  = new JoystickButton(operator, O_BT8);
//		climbLock    = new JoystickButton(operator, O_BT9);
		intakeEngage = new JoystickButton(operator, O_BT10);
		intakeOut    = new JoystickButton(operator, O_BT11);
		intakeOpen   = new JoystickButton(operator, O_BT12);
		
		turboTrue    = new JoystickButton(driver, 4);
		turboFalse   = new JoystickButton(driver, 5);

		manualSafety = new JoystickButton(manual, 1);
		
		//assign commands
		turboTrue.whenPressed(new TurboOn());
		turboFalse.whenPressed(new TurboOff());
		
		//climb control
		climbUp.whenPressed(new ClimbUp());
		climbDown.whenPressed(new ClimbDown());
		
		//delivery control
		intakeIn.whenPressed(new IntakeIn());
		intakeOut.whenPressed(new IntakeOut());
		
		intakeOpen.whenPressed(new OpenClaw());
		intakeClose.whenPressed(new CloseClaw());
		intakeEngage.whenPressed(new EngageOn());
		
		//TODO kill me please TY
		double liftAxis = manual.getRawAxis(1);
		manualSafety.whenActive(new LiftManual(liftAxis));
	
		liftScale.whenPressed(new aaRemoveMeLiftUp(1));
		liftSwitch.whenPressed(new aaRemoveMeLiftUp(-1));
	}
	
	//misc
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
		return operator.getRawButton(O_BT5);
	}
	
	public boolean getClimbDown() {
		return !operator.getRawButton(O_BT6);
	}
	
	public boolean getIntakeIn() {
		return operator.getRawButton(O_BT7);
	}
	
	public boolean getIntakeOut() {
		return operator.getRawButton(O_BT11);
	}
	
	//TODO remove me
	public boolean getLiftUp() {
		return operator.getRawButton(O_BT1);
	}
	
	public boolean getLiftDown() {
		return operator.getRawButton(O_BT2);
	}
}