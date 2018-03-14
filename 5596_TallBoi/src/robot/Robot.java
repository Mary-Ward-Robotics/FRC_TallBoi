/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.commands.auto.LeftAuto;
import robot.commands.auto.MiddleAuto;
import robot.commands.auto.RightAuto;
import robot.subsystems.ChassisSubsystem;
import robot.subsystems.ClimbSubsystem;
import robot.subsystems.DeliverySubsystem;
import robot.subsystems.LiftSubsystem;
import robot.subsystems.TechnicalSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static ClimbSubsystem climb;
	public static ChassisSubsystem chassis;
	public static DeliverySubsystem delivery;
	public static LiftSubsystem lift;
	public static TechnicalSubsystem technical;
	public static OI oi;
	
	private static SendableChooser<CommandGroup> posSelect;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	public void robotInit() {
		chassis = new ChassisSubsystem(5,0.02,2,5);
		delivery = new DeliverySubsystem();
		climb = new ClimbSubsystem();
		technical = new TechnicalSubsystem();
		lift = new LiftSubsystem();
		
		oi = new OI();
		
		posSelect = new SendableChooser<CommandGroup>();
		posSelect.addObject("Left", new LeftAuto());
		posSelect.addObject("Middle", new MiddleAuto());
		posSelect.addObject("Right Auto", new RightAuto());
		
		
		SmartDashboard.putData(posSelect);
		SmartDashboard.putData(chassis);
		SmartDashboard.putData(delivery);
		SmartDashboard.putData(climb);
		log();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	
	public void disabledInit() {

	}


	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}
	
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
		boolean lift = oi.getoperator().getRawButton(1);
		SmartDashboard.putBoolean("lift: ", lift);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	
	public void testPeriodic() {
		log();
	}
	
	public void log() {
		delivery.log();
		climb.log();
		chassis.log();
		technical.log();
	}
}
