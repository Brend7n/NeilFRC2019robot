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
    public static final int backRight = 2;
    public static final int frontLeft = 6;
    public static final int middleLeft = 4;
    public static final int backLeft = 5;

    public static final int elavator = 1;
  
    // PCM Channels
    public static final int doubleSolenoid1 = 3;
    public static final int doubleSolenoid2 = 4;
    public static final int doubleSolenoidShiftLefta = 0;
    public static final int doubleSolenoidShiftLeftb = 7;
    public static final int doubleSolenoidShiftRighta = 1;
    public static final int doubleSolenoidShiftRightb = 6;

    // elavator constants 4096 is 360 degrees
    public static final int highElavatorPosition = 30 * 4096;
    public static final int medElavatorPosition = 15 * 4096;
    public static final int lowElavatorPosition = 0;
    public static final int elavatorMax = 30 * 4096;

/*
  If you are using multiple modules, make sure to define both the port
  number and the module. For example you with a rangefinder:
  public static int rangefinderPort = 1;
  public static int rangefinderModule = 1;
  */
}
