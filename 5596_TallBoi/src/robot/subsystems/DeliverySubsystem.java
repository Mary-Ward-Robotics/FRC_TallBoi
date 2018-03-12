package robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
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
	private Spark m_engage = new Spark(RobotMap.ENGAGE);
	private DoubleSolenoid m_claw = new DoubleSolenoid(RobotMap.LINTAKE, RobotMap.RINTAKE);
	private AnalogPotentiometer m_liftPot = new AnalogPotentiometer(RobotMap.LIFTPOT);
	private DigitalInput m_boxSwitch = new DigitalInput(RobotMap.BOXSWITCH);
	
	private boolean open = false;

    public void initDefaultCommand() {
    }
    
    //lift
    public void setLiftUp(double speed) {
    	m_lift.set(-speed);
    }
    
    public void setLiftDown(double speed) {
    	m_lift.set(speed);
    }
 
    public void setLiftStop() {
    	m_lift.set(0);
    }
    
    public double getLiftPotValue() {
    	return m_liftPot.get();
    }
    
    //intake
    public void setIntakeIn() {
    	m_intake.set(-0.8);
    }
    
    public void setIntakeOut() {
    	m_intake.set(0.8);
    }
    
    public void setIntakeStop() {
    	m_intake.set(0);
    }
    
    public void setIntakeOpen() {
    	m_claw.set(Value.kForward);
    	open = true;
    }
    
    public void setIntakeClose() {
    	m_claw.set(Value.kReverse);
    	open = false;
    }
    
    public boolean getIntakeOpen() {
    	return open;
    }
    
    public boolean getBoxSwitch() {
    	return m_boxSwitch.get();
    }
    
    //engage
    public void setEngageSpeed(double speed) {
    	m_engage.set(speed);
    }
    
    public void log() {
    	SmartDashboard.putNumber("LiftPot Voltage: ", getLiftPotValue());
    	SmartDashboard.putBoolean("Has Box: ", getBoxSwitch());
    	SmartDashboard.putBoolean("Claw Open: ", getIntakeOpen());
    	SmartDashboard.putNumber("lift speed: ", m_lift.get());
    	SmartDashboard.putNumber("Intake Speed: ", m_intake.get());
    	
    }
}