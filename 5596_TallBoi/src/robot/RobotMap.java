package robot;

public class RobotMap {
	//Motors
	public static final int RDRIVE = 0;
	public static final int LDRIVE = 1;
	public static final int INTAKE = 2;
	public static final int LIFT   = 3;
	public static final int CLIMB  = 4;
	public static final int ENGAGE = 5;

	//Pneumatics
	public static final int LINTAKE  = 0;
	public static final int RINTAKE  = 1;
	public static final int RSHIFTER = 2;
	public static final int LSHIFTER = 3;

	//Sensors
	//DIO
	public static final int LENCODERS1  = 0; //encoder s1 is V, GND, and SIGNAL
	public static final int LENCODERS2  = 1; //encoder s2 is single SIGNAL
	public static final int RENCODERS1  = 2;
	public static final int RENCODERS2  = 3;
	public static final int DISTANCES11 = 4; //distance s1 is V, GND, and SIGNAL
	public static final int DISTANCES12 = 5; //distance s2 is single SIGNAL
	public static final int DISTANCES21 = 6;
	public static final int DISTANCES22 = 7;
	public static final int BOXSWITCH   = 8; //limit switch
	//ANALOG
	public static final int LIFTPOT     = 0; //potentiometer
	public static final int CLIMBPOT    = 1;
	
	
	//CAN bus
	public static final int PIGEON     = 2; //Pidgeon IMU
	public static final int COMPRESSOR = 0;
	public static final int PDP        = 3;
	
	
	//PDP map
	public static final int PDP_INTAKE  = 0;
	public static final int PDP_LIFT    = 1;
	public static final int PDP_CLIMB   = 2;
	public static final int PDP_ENGAGE  = 3;
	
	public static final int PDP_LDRIVE1 = 15;
	public static final int PDP_LDRIVE2 = 14;
	public static final int PDP_RDRIVE1 = 13;
	public static final int PDP_RDRIVE2 = 12;
	
	public static final int PDP_BLINKEN = 11;
	public static final int PDP_PIGEON  = 10;
}