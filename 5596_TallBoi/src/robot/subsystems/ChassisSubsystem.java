package robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.DriveWithJoystick;


public class ChassisSubsystem extends Subsystem {
	private Spark m_ldrive = new Spark(RobotMap.LDRIVE);
	private Spark m_rdrive = new Spark(RobotMap.RDRIVE);
	private Encoder m_lencoder = new Encoder(RobotMap.LENCODERS1, RobotMap.LENCODERS2);
	private Encoder m_rencoder = new Encoder(RobotMap.RENCODERS1, RobotMap.RENCODERS2);
	private DoubleSolenoid m_shifter = new DoubleSolenoid(RobotMap.LSHIFTER,RobotMap.RSHIFTER);
	
	private boolean m_turbo = false;
	
	double rate = 0;
	double maxspeed = 0;
	
	public ChassisSubsystem(){
		m_lencoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		m_rencoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		
	}
	
	public void init() {
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
	}
    
    
    //tank drive
    public void drive(double left, double right) {
    	m_ldrive.set(left);
    	m_rdrive.set(-right);
    }
    
    public void reset() {
		m_lencoder.reset();
		m_rencoder.reset();
	}
    
    public double getDistance() {
		return (m_lencoder.getDistance() + m_rencoder.getDistance()) / 2;
	}
    
    public double getRateLeft() {
    	return m_lencoder.getRate();
    }
    
    public double getRateRight() {
    	return m_rencoder.getRate();
    }
    
    public void setTurbo(boolean turbo) {
    	if(turbo == true) {
    		m_turbo = true;
    		m_shifter.set(Value.kForward);
    	} else {
    		m_turbo = false;
    		m_shifter.set(Value.kReverse);
    	}
    }
    
    public boolean getTurbo() {
    	return m_turbo;
    }
    
    public void log() {
    	SmartDashboard.putBoolean("Turbo: ", getTurbo());
    	SmartDashboard.putNumber("Left motor: ", getRateLeft());
    	SmartDashboard.putNumber("Right motor: ", getRateRight());
//    	SmartDashboard.putNumber("Heading ":, getHeading());
    }
}