package robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	private Spark m_engage = new Spark(RobotMap.ENGAGE);
	private DoubleSolenoid m_claw = new DoubleSolenoid(RobotMap.LINTAKE, RobotMap.RINTAKE);
	private DigitalInput m_boxSwitch = new DigitalInput(RobotMap.BOXSWITCH);
	
	private boolean open = false;

	public DeliverySubsystem() {
	}
	
    public void initDefaultCommand() {
    }
    
    //intake
    public void setIntakeIn() {
    	m_intake.set(-0.3);
    }
    
    public void setIntakeOut() {
    	m_intake.set(0.3);
    }
    
    public void setIntakeStop() {
    	m_intake.set(0.05);
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
    	SmartDashboard.putBoolean("Has Box: ", getBoxSwitch());
    	SmartDashboard.putBoolean("Claw Open: ", getIntakeOpen());
    	SmartDashboard.putNumber("Intake Speed: ", m_intake.get());
    	
    }
}