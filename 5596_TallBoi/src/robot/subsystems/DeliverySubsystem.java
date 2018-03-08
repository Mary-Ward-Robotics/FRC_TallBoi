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
	private DoubleSolenoid m_clawL = new DoubleSolenoid(RobotMap.LINTAKE1, RobotMap.LINTAKE2);
	private DoubleSolenoid m_clawR = new DoubleSolenoid(RobotMap.RINTAKE1, RobotMap.RINTAKE2);
	private DoubleSolenoid m_engage = new DoubleSolenoid(RobotMap.ENGAGE1, RobotMap.ENGAGE2);
	private AnalogInput m_liftPot = new AnalogInput(RobotMap.LIFTPOT);
	private DigitalInput m_boxSwitch = new DigitalInput(RobotMap.BOXSWITCH);
	
	
	private boolean open = false;

    public void initDefaultCommand() {
    }
    
    public void setLiftUp() {
    	m_lift.set(-1);
    }
    
    public void setLiftDown() {
    	m_lift.set(1);
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
    	m_clawL.set(Value.kReverse);
    	m_clawR.set(Value.kReverse);
    	open = true;
    }
    
    public void closeClaw() {
    	m_clawL.set(Value.kForward);
    	m_clawR.set(Value.kForward);
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
    }
    
    public void engageOff() {
    	m_engage.set(Value.kReverse);
    }
    
    public void log() {
    	SmartDashboard.putNumber("LiftPot Voltage: ", getLiftPotValue());
    	SmartDashboard.putBoolean("Has Box: ", getBoxSwitch());
    	SmartDashboard.putBoolean("Claw Open: ", getClawOpen());
    }
}

