package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
	private Spark m_climb = new Spark(RobotMap.CLIMB);
	private AnalogInput m_climbPot = new AnalogInput(RobotMap.CLIMBPOT);
	
	private Timer timer = new Timer();
	
	double val1 = 0;
	double val2 = 0;

    public void initDefaultCommand() {
    }
    
    public void setClimbUp() {
    	m_climb.set(-1);
    }
    
    public void setClimbDown() {
    	m_climb.set(1);
    }
    
    public void setClimbStop() {
    	m_climb.set(0);
    }
    
    public double getPotValue(){
    	return m_climbPot.getVoltage();
    }
    
    public double getPotRate() {
    	Timer.delay(1);
    	double difference;
    	val2 = val1;
    	val1 = getPotValue();
    	difference = val2-val1;
    	return difference;
    }
    
    
    public double getTimer(){
    	return timer.get();
    }
    
    public void setTimer() {
    }
    
    public void log() {
    	SmartDashboard.putNumber("ClimbPot Voltage: " , getPotValue());
    	SmartDashboard.putNumber("motor", m_climb.get());
    }
}

