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

public class OI {
	private Joystick driver = new Joystick(RobotMap.DRIVER);
	private Joystick operator = new Joystick(RobotMap.OPERATOR);
	private Joystick manual = new Joystick(RobotMap.MANUAL);
	
	//create joystick buttons
		private int
			//operator buttons logitech
//			O_SCALE = 9, O_SWITCH = 11, O_EXCHANGE = 16, O_RESET = 17, O_UPC = 10, O_UPD = 12,
//			O_BOXIN = 3, O_BOXCLOSE = 8, /*O_BT9 = 9,*/ O_ENGAGE = 1, O_BOXOUT = 4, O_BOXOPEN = 7,
			
			//operator buttons panel
		O_SCALE = 2, O_SWITCH = 3, O_EXCHANGE = 4, O_RESET = 5, O_UPC = 6, O_UPD = 7,
		O_BOXIN = 8, O_BOXCLOSE = 9, /*O_BT9 = 10,*/ O_ENGAGE = 11, O_BOXOUT = 12, O_BOXOPEN = 13,
			
			//driver buttons
			D_LOW = 5, D_HIGH = 6,
			//driver sticks
			D_LEFT = 1, D_RIGHT = 5,
			
			//manual button
			M_SAFETY = 1,
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
		liftScale    = new JoystickButton(operator, O_SCALE);
		liftSwitch   = new JoystickButton(operator, O_SWITCH);
		liftExchange = new JoystickButton(operator, O_EXCHANGE);
		liftReset    = new JoystickButton(operator, O_RESET);
		climbUp      = new JoystickButton(operator, O_UPC);
		climbDown    = new JoystickButton(operator, O_UPD);
		intakeIn     = new JoystickButton(operator, O_BOXIN);
		intakeClose  = new JoystickButton(operator, O_BOXCLOSE);
//		climbLock    = new JoystickButton(operator, O_BT9);
		intakeEngage = new JoystickButton(operator, O_ENGAGE);
		intakeOut    = new JoystickButton(operator, O_BOXOUT);
		intakeOpen   = new JoystickButton(operator, O_BOXOPEN);
		
		turboTrue    = new JoystickButton(driver, D_HIGH);
		turboFalse   = new JoystickButton(driver, D_LOW);

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
	
		liftScale.whenPressed(new aaRemoveMeLiftUp(0.6));
		liftSwitch.whenPressed(new aaRemoveMeLiftDown(0.6));
	}
	
	//misc
	public Joystick getdriver() {
		return driver;
	}
	
	public Joystick getoperator() {
		return operator;
	}
	
	public double getLeft() {
		return driver.getRawAxis(D_LEFT);
	}
	
	public double getRight() {
		return driver.getRawAxis(D_RIGHT);
	}
	
	public boolean getClimbUp() {
		return operator.getRawButton(O_UPC);
	}
	
	public boolean getClimbDown() {
		return operator.getRawButton(O_UPD);
	}
	
	public boolean getIntakeIn() {
		return operator.getRawButton(O_BOXIN);
	}
	
	public boolean getIntakeOut() {
		return operator.getRawButton(O_BOXOUT);
	}
	
	//TODO remove me
	public boolean getLiftUp() {
		return operator.getRawButton(O_SCALE);
	}
	
	public boolean getLiftDown() {
		return operator.getRawButton(O_SWITCH);
	}
	
	public boolean getLiftManual() {
		return manual.getRawButton(M_SAFETY);
	}
}