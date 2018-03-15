package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.operator.LiftHold;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
	private static double kP;
	private static double kI;
	private static double kD;
	
	private static Spark m_lift;
	private static AnalogInput m_liftPot;
	private static PIDController m_liftPID;
	
	public LiftSubsystem() {
		kP = -5.00;
		kI = -0.02;
		kD = -2.00;
		m_lift = new Spark(RobotMap.LIFT);
		m_liftPot = new AnalogInput(RobotMap.LIFTPOT);
		m_liftPID = new PIDController(kP, kI, kD, m_liftPot, m_lift);
		m_liftPID.setOutputRange(-1, 1);
	}
	
    public void initDefaultCommand() {
//    	setDefaultCommand(new LiftHold());
    }
    
    //lift
    public void setSpeed(double speed) {
    	m_lift.set(-speed);
    }
 
    public void setLiftStop() {
    	m_lift.set(0);
    }
    
    public double getLiftPotValue() {
    	return m_liftPot.getAverageVoltage();
    }
    
    //PID
    public static void enableLiftPID(boolean enable) {
    	if(enable == true) {
    		m_liftPID.enable();
    	} else 
    		if(enable == false) {
    			m_liftPID.disable();
    		}
    }
    
    public static void setGoalPID(double setpoint) {
    	m_liftPID.setSetpoint(setpoint);
    }
    
    public static PIDController getLiftPID() {
		return m_liftPID;
	}
    
  	protected double returnPIDInput() {
  		return m_liftPot.getAverageVoltage();
  	}
  	
  	protected void usePIDOutput(double output) {
  		m_lift.pidWrite(output);
  	}

	public void log() {
		SmartDashboard.putNumber("liftpotvalue", returnPIDInput());
	}
}

