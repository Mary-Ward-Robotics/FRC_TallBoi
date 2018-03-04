package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
	private Spark m_climb = new Spark(RobotMap.CLIMB);
	private AnalogInput m_climbPot = new AnalogInput(RobotMap.CLIMBPOT);

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
}

