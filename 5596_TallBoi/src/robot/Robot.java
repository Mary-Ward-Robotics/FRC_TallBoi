/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.subsystems.ChassisSubsystem;
import robot.subsystems.ClimbSubsystem;
import robot.subsystems.DeliverySubsystem;
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
	public static TechnicalSubsystem technical;
	
	public static OI oi;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	public void robotInit() {
		chassis = new ChassisSubsystem();
		delivery = new DeliverySubsystem();
		climb = new ClimbSubsystem();
		technical = new TechnicalSubsystem();
		oi = new OI();
		
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

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */

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
