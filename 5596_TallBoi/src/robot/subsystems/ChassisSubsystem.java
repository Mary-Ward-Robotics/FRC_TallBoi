package robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotConst;
import robot.RobotMap;
import robot.commands.driver.DriveWithJoystick;


public class ChassisSubsystem extends Subsystem {
	private Spark m_ldrive;
	private Spark m_rdrive;
	private DoubleSolenoid m_shifter;
	
	private Encoder m_lencoder;
	private Encoder m_rencoder;
	private PigeonIMU m_gyro;
	
	
	private PIDController m_leftPID;
	private PIDController m_rightPID;
	
	private boolean m_turbo = false;
	
	double rate = 0;
	double maxspeed = 0;
	
	int c_ldrive = robot.JoystickMap.XB_LEFT;
	int c_rdrive = robot.JoystickMap.XB_RIGHT;
	
	public ChassisSubsystem(double kP, double kI, double kD, double kF){
		m_ldrive = new Spark(RobotMap.LDRIVE);
		m_rdrive = new Spark(RobotMap.RDRIVE);
		m_shifter = new DoubleSolenoid(RobotMap.LSHIFTER,RobotMap.RSHIFTER);
		m_lencoder = new Encoder(RobotMap.LENCODERS1, RobotMap.LENCODERS2);
		m_rencoder = new Encoder(RobotMap.RENCODERS1, RobotMap.RENCODERS2);
		m_gyro   = new PigeonIMU(RobotMap.PIGEON);
		
		m_lencoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		m_rencoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		
		m_leftPID = new PIDController(kP, kI, kD, kF, m_lencoder, m_ldrive);
		m_leftPID.setContinuous(true);
		m_leftPID.setOutputRange(-1, 1);
		
		m_rightPID = new PIDController(kP, kI, kD, kF, m_rencoder, m_rdrive);
		m_rightPID.setContinuous(true);
		m_leftPID.setOutputRange(-1, 1);
	}
	
	public void init() {
		m_gyro.setFusedHeadingToCompass(1);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick(c_ldrive, c_rdrive));
	}
    
    
    //motors
    public void setRawSpeed(double lspeed, double rspeed) {
    	m_ldrive.set(lspeed);
    	m_rdrive.set(rspeed);
    }
    
    public void drive(double left, double right) {
    	m_leftPID.setSetpoint(left);
    	m_rightPID.setSetpoint(right);
    }
    
    //encoders
    public double getDistance() {
		return (m_lencoder.getDistance() + m_rencoder.getDistance()) / 2;
	}
    
    public double getRateLeft() {
    	return m_lencoder.getRate();
    }
    
    public double getRateRight() {
    	return m_rencoder.getRate();
    }
    
    //gear shift
    public void setTurbo(boolean turbo) {
    	if(turbo == true) {
    		m_turbo = true;
    		m_shifter.set(Value.kForward);
    		m_leftPID.setInputRange(0, RobotConst.HIGH_GEAR_SPEED);
    		m_leftPID.setInputRange(0, RobotConst.HIGH_GEAR_SPEED);
    	} else {
    		m_turbo = false;
    		m_shifter.set(Value.kReverse);
    		m_leftPID.setInputRange(0, RobotConst.LOW_GEAR_SPEED);
    		m_leftPID.setInputRange(0, RobotConst.LOW_GEAR_SPEED);
    		
    		
    	}
    }
    
    public boolean getTurbo() {
    	return m_turbo;
    }
    
    //gyro
    public double getHeading() {
    	return m_gyro.getCompassHeading();
    }
    
    public double getAngle() {
    	return m_gyro.getAbsoluteCompassHeading();
    }
    
    public void resetGyro() {
    	m_gyro.setCompassAngle(0,1);
    }
    
    //misc  
    public void reset() {
		m_lencoder.reset();
		m_rencoder.reset();
	}
    
    
    public void log() {
    	SmartDashboard.putBoolean("Turbo: ", getTurbo());
    	SmartDashboard.putNumber("Left motor: ", getRateLeft());
    	SmartDashboard.putNumber("Right motor: ", getRateRight());
    	SmartDashboard.putNumber("Heading: ", getHeading());
    	SmartDashboard.putNumber("Angle : ", getAngle());
    }
}