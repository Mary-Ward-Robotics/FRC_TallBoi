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
	private Joystick driver = new Joystick(JoystickMap.DRIVER);
	private Joystick operator = new Joystick(JoystickMap.OPERATOR);
	private Joystick manual = new Joystick(JoystickMap.MANUAL);

		private JoystickButton 
			liftScale, liftSwitch, liftExchange, liftReset,
			climbUp, climbDown, intakeIn, intakeClose,
			intakeEngage, intakeOut, intakeOpen, 
			turboHigh, turboLow, manualSafety;

	public OI() {
		//assign buttons
		liftScale    = new JoystickButton(operator, JoystickMap.BB_SCALE);
		liftSwitch   = new JoystickButton(operator, JoystickMap.BB_SWITCH);
		liftExchange = new JoystickButton(operator, JoystickMap.BB_EXCHANGE);
		liftReset    = new JoystickButton(operator, JoystickMap.BB_RESET);
		climbUp      = new JoystickButton(operator, JoystickMap.BB_CLIMBUP);
		climbDown    = new JoystickButton(operator, JoystickMap.BB_CLIMBDOWN);
		intakeIn     = new JoystickButton(operator, JoystickMap.BB_BOXIN);
		intakeClose  = new JoystickButton(operator, JoystickMap.BB_BOXCLOSE);
		intakeEngage = new JoystickButton(operator, JoystickMap.BB_ENGAGE);
		intakeOut    = new JoystickButton(operator, JoystickMap.BB_BOXOUT);
		intakeOpen   = new JoystickButton(operator, JoystickMap.BB_BOXOPEN);
		
		turboHigh    = new JoystickButton(driver, JoystickMap.XB_HIGH);
		turboLow     = new JoystickButton(driver, JoystickMap.XB_LOW);

		manualSafety = new JoystickButton(manual, JoystickMap.LT_OVERIDE);
		
		//assign commands
		turboHigh.whenPressed(new TurboOn());
		turboLow.whenPressed(new TurboOff());
		
		//climb control
		climbUp.whenActive(new ClimbUp());
		climbDown.whenActive(new ClimbDown());
		
		//delivery control
		intakeIn.whenActive(new IntakeIn());
		intakeOut.whenActive(new IntakeOut());
		
		intakeOpen.whenPressed(new OpenClaw());
		intakeClose.whenPressed(new CloseClaw());
		intakeEngage.whenActive(new EngageOn());
		
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
	
	public Joystick getManual() {
		return manual;
	}
}