package robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.test.FixStickyFaultPCM;
import robot.commands.test.FixStickyFaultPDP;

public class TechnicalSubsystem extends Subsystem {
	private static final PowerDistributionPanel m_pdp = new PowerDistributionPanel(RobotMap.PDP);
	private static final Compressor m_compressor = new Compressor(RobotMap.COMPRESSOR);
	
    public void initDefaultCommand() {
    }
    
    
    //Power Distribution Panel
    public static double PDPgetCurrent() {
    	return m_pdp.getTotalCurrent();
    }
    
    public static double PDPgetCurrent(int port) {
    	return m_pdp.getCurrent(port);
    }
    
    public static double PDPgetVoltage() {
    	return m_pdp.getVoltage();
    }
    
    public static double PDPgetTemp() {
    	return m_pdp.getTemperature();
    }
    
    public static double PDPgetPower() {
    	return m_pdp.getTotalPower();
    }
    
    public static double PDPgetEnergy() {
    	return m_pdp.getTotalEnergy();
    }
    
    public void PDPreset() {
    	m_pdp.clearStickyFaults();
    	m_pdp.resetTotalEnergy();
    }
    
    
    //Pneumatics Control Module
    public static boolean CgetRunning() {
    	return m_compressor.enabled();
    }
    
    public static double CgetCurrent() {
    	return m_compressor.getCompressorCurrent();
    }
    
    public static boolean CgetSwitch() {
    	return m_compressor.getPressureSwitchValue();
    }
    
    public void Cstart() {
    	m_compressor.start();
    }
    
    public void Cstop() {
    	m_compressor.stop();
    }
    
    public void PCMreset() {
    	m_compressor.clearAllPCMStickyFaults();
    }
    
    
    //misc
    public void log() {
    	//PDP
    	SmartDashboard.putNumber("PDP voltage", PDPgetVoltage());
    	SmartDashboard.putNumber("PDP power", PDPgetPower());
    	SmartDashboard.putNumber("PDP energy", PDPgetEnergy());
    	SmartDashboard.putNumber("PDP total current", PDPgetCurrent());
    	
    	SmartDashboard.putNumber("PDP intake current", PDPgetCurrent(RobotMap.PDP_INTAKE));
    	SmartDashboard.putNumber("PDP engage current", PDPgetCurrent(RobotMap.PDP_ENGAGE));
    	SmartDashboard.putNumber("PDP lift current", PDPgetCurrent(RobotMap.PDP_LIFT));
    	SmartDashboard.putNumber("PDP climb current", PDPgetCurrent(RobotMap.PDP_CLIMB));
    	SmartDashboard.putNumber("PDP ldrive1", PDPgetCurrent(RobotMap.PDP_LDRIVE1));
    	SmartDashboard.putNumber("PDP ldrive2", PDPgetCurrent(RobotMap.PDP_LDRIVE2));
    	SmartDashboard.putNumber("PDP rdrive1", PDPgetCurrent(RobotMap.PDP_RDRIVE1));
    	SmartDashboard.putNumber("PDP rdrive2", PDPgetCurrent(RobotMap.PDP_RDRIVE2));
    	
    	SmartDashboard.putNumber("PDP blinken current", PDPgetCurrent(RobotMap.PDP_BLINKEN));
    	SmartDashboard.putNumber("PDP pigeon IMU current", PDPgetCurrent(RobotMap.PDP_PIGEON));
    	
//    	SmartDashboard.putNumber();
    	
    	SmartDashboard.putNumber("Compressor current", CgetCurrent());
    	SmartDashboard.putBoolean("Compressor running", CgetRunning());
    	SmartDashboard.putBoolean("Pressure switch", CgetSwitch());
    	
    	SmartDashboard.putData("Fix sticky faults PDP", new FixStickyFaultPDP());
    	SmartDashboard.putData("Fix sticky faults PCM", new FixStickyFaultPCM());
    	
    	SmartDashboard.putData("Turn compressor on", new FixStickyFaultPCM());
    	SmartDashboard.putData("Turn compressor off", new FixStickyFaultPCM());
    }
}

