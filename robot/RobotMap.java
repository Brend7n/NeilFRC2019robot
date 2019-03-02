package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Drivetrain speed controllers
    public static final int frontRight = 0;
    public static final int middleRight = 1;
    public static final int backRight = 7;
    public static final int frontLeft = 6;
    public static final int middleLeft = 4;
    public static final int backLeft = 5;

    public static final int intake = 2;
    //can bus ids
    public static final int elavator = 1;
  
    // PCM Channels
    public static final int doubleSolenoid1 = 1;
    public static final int doubleSolenoid2 = 5;
    public static final int doubleSolenoidShiftLefta = 7;
    public static final int doubleSolenoidShiftLeftb = 0;
    public static final int doubleSolenoidShiftRighta = 3;
    public static final int doubleSolenoidShiftRightb = 4;

    // elavator constants 4096 is 360 degrees
    // these numbers are not tested yet
    public static final int highElavatorPosition = 5 *4096;
    public static final int medElavatorPosition = 3 * 4096;
    public static final int lowElavatorPosition = 1 * 4096;
    public static final int elavatorMax = 6 * 4096;

    public static final double highSpeedPositionRange = 5 * 4096;
    public static final double medSpeedPositionRange = 3 * 4096;
    public static final double lowSpeedPositionRange = 1 * 4096;

    // Digital Input Ports 
  // Drivetrain Encoder Ports
    //public static final int enc1a = 0;
    //public static final int enc1b = 1;
/*
  // Intake Ultrasonic Ports
    public static final int ping = 4;
    public static final int echo = 5;

  If you are using multiple modules, make sure to define both the port
  number and the module. For example you with a rangefinder:
  public static int rangefinderPort = 1;
  public static int rangefinderModule = 1;
  */
}
