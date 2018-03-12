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
//	private static final 

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
    	SmartDashboard.putNumber("PDP port0 current", PDPgetCurrent(0));
    	SmartDashboard.putNumber("PDP port1 current", PDPgetCurrent(1));
    	SmartDashboard.putNumber("PDP port2 current", PDPgetCurrent(2));
    	SmartDashboard.putNumber("PDP port3 current", PDPgetCurrent(3));
    	SmartDashboard.putNumber("PDP port4 current", PDPgetCurrent(4));
    	SmartDashboard.putNumber("PDP port5 current", PDPgetCurrent(5));
    	SmartDashboard.putNumber("PDP port6 current", PDPgetCurrent(6));
    	SmartDashboard.putNumber("PDP port7 current", PDPgetCurrent(7));
    	SmartDashboard.putNumber("PDP port8 current", PDPgetCurrent(8));
    	SmartDashboard.putNumber("PDP port9 current", PDPgetCurrent(9));
    	SmartDashboard.putNumber("PDP port10 current", PDPgetCurrent(10));
    	SmartDashboard.putNumber("PDP port11 current", PDPgetCurrent(11));
    	SmartDashboard.putNumber("PDP port12 current", PDPgetCurrent(12));
    	SmartDashboard.putNumber("PDP port13 current", PDPgetCurrent(13));
    	SmartDashboard.putNumber("PDP port14 current", PDPgetCurrent(14));
    	SmartDashboard.putNumber("PDP port15 current", PDPgetCurrent(15));
    	
    	SmartDashboard.putNumber("Compressor current", CgetCurrent());
    	SmartDashboard.putBoolean("Compressor running", CgetRunning());
    	SmartDashboard.putBoolean("Pressure switch", CgetSwitch());
    	
    	SmartDashboard.putData("Fix sticky faults PDP", new FixStickyFaultPDP());
    	SmartDashboard.putData("Fix sticky faults PCM", new FixStickyFaultPCM());
    	
    	SmartDashboard.putData("Turn compressor on", new FixStickyFaultPCM());
    	SmartDashboard.putData("Turn compressor off", new FixStickyFaultPCM());
    }
}

