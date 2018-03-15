/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import robot.commands.driver.TurboOff;
import robot.commands.driver.TurboOn;
import robot.commands.operator.ClimbDown;
import robot.commands.operator.ClimbUp;
import robot.commands.operator.CloseClaw;
import robot.commands.operator.EngageOn;
import robot.commands.operator.IntakeIn;
import robot.commands.operator.IntakeOut;
import robot.commands.operator.IntakeStop;
import robot.commands.operator.LiftManual;
import robot.commands.operator.OpenClaw;
import robot.commands.operator.aaRemoveMeLiftDown;
import robot.commands.operator.aaRemoveMeLiftUp;

public class OI {
	private final Joystick driver = new Joystick(JoystickMap.DRIVER);
	private final Joystick operator = new Joystick(JoystickMap.OPERATOR);
	private final Joystick manual = new Joystick(JoystickMap.MANUAL);

		private final JoystickButton 
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
		intakeIn.whenPressed(new IntakeIn());
		intakeOut.whenPressed(new IntakeOut());
		intakeIn.whenReleased(new IntakeStop());
		intakeOut.whenReleased(new IntakeStop());
		
		intakeOpen.whenPressed(new OpenClaw());
		intakeClose.whenPressed(new CloseClaw());
//		intakeEngage.whenActive(new EngageOn()); TODO new engage command
		
		//manual overide
		double liftAxis = manual.getRawAxis(1);
		manualSafety.whenActive(new LiftManual(liftAxis));
		
		//TODO fix me
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