package robot;

public class RobotMap {
	//Motors
	public static int RDRIVE = 0;
	public static int LDRIVE = 1;
	public static int INTAKE = 2;
	public static int LIFT   = 3;
	public static int CLIMB  = 4;

	//Pneumatics
	public static int RSHIFTER   = 2;
	public static int LSHIFTER   = 3;
	public static int LINTAKE    = 0;
	public static int RINTAKE    = 1;
	public static int ENGAGE1    = 6;
	public static int ENGAGE2    = 7;
	
		
	//Sensors
	//DIO
	public static int LENCODERS1  = 0; //encoder s1 is V, GND, and SIGNAL
	public static int LENCODERS2  = 1; //encoder s2 is single SIGNAL
	public static int RENCODERS1  = 2;
	public static int RENCODERS2  = 3;
	public static int DISTANCES11 = 4; //distance s1 is V, GND, and SIGNAL
	public static int DISTANCES12 = 5; //distance s2 is single SIGNAL
	public static int DISTANCES21 = 6;
	public static int DISTANCES22 = 7;
	public static int BOXSWITCH   = 8; //limit switch
	//ANALOG
	public static int LIFTPOT     = 0; //potentiometer
	public static int CLIMBPOT    = 1;
	//CAN
	public static int PIDGEON     = 0; //gadgeteer pidgeon
}