package robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;

/**
 *
 */
public class DeliverySubsystem extends Subsystem {
	private Spark m_intake = new Spark(RobotMap.INTAKE);
	private Spark m_lift = new Spark(RobotMap.LIFT);
	private DoubleSolenoid m_claw = new DoubleSolenoid(RobotMap.LINTAKE, RobotMap.RINTAKE);
	private DoubleSolenoid m_engage = new DoubleSolenoid(RobotMap.ENGAGE1, RobotMap.ENGAGE2);
	private AnalogInput m_liftPot = new AnalogInput(RobotMap.LIFTPOT);
	private DigitalInput m_boxSwitch = new DigitalInput(RobotMap.BOXSWITCH);
	
	
	private boolean open = false;
	private boolean engaged = false;

    public void initDefaultCommand() {
    }
    
    public void setLiftUp(double speed) {
    	m_lift.set(speed);
    }
    
    public void setLiftDown(double speed) {
    	m_lift.set(-speed);
    }
 
    public void setLiftStop() {
    	m_lift.set(0);
    }
    
    public void setIntakeIn() {
    	m_intake.set(-0.8);
    }
    
    public void setIntakeOut() {
    	m_intake.set(0.8);
    }
    
    public void setIntakeStop() {
    	m_intake.set(0);
    }

    public void openClaw() {
    	m_claw.set(Value.kReverse);
    	open = true;
    }
    
    public void closeClaw() {
    	m_claw.set(Value.kForward);
    	open = false;
    }
    
    public boolean getClawOpen() {
    	return open;
    }
    
    public double getLiftPotValue() {
    	return m_liftPot.getVoltage();
    }
    
    public boolean getBoxSwitch() {
    	return m_boxSwitch.get();
    }
    
    public void engageOn() {
    	m_engage.set(Value.kForward);
    	engaged = true;
    }
    
    public void engageOff() {
    	m_engage.set(Value.kReverse);
    	engaged = false;
    }
    
    public boolean getEngaged() {
    	return engaged;
    }
    
    public void log() {
    	SmartDashboard.putNumber("LiftPot Voltage: ", getLiftPotValue());
    	SmartDashboard.putBoolean("Has Box: ", getBoxSwitch());
    	SmartDashboard.putBoolean("Claw Open: ", getClawOpen());
    	SmartDashboard.putNumber("lift speed: ", m_lift.get());
    	SmartDashboard.putNumber("Intake Speed: ", m_intake.get());
    	SmartDashboard.putBoolean("Engaged", getEngaged());
    }
}