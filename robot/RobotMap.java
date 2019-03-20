package frc.robot;

public class RobotMap {
    // elavator constants 4096 is 360 degrees
    // these numbers are not tested yet
    public static final int highElavatorPosition = 20 *4096;
    public static final int medElavatorPosition = 10 * 4096;
    public static final int lowElavatorPosition = 5 * 4096;
    public static final int elavatorMax = 50 * 4096;

    public static final double highSpeedPositionRange = 1 * 4096;
    public static final double medSpeedPositionRange = 0.5 * 4096;
    public static final double lowSpeedPositionRange = 0.1 * 4096;
    
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
    public static final int doubleSolenoid1 = 2;
    public static final int doubleSolenoid2 = 5;
    public static final int doubleSolenoidShiftLefta = 7;
    public static final int doubleSolenoidShiftLeftb = 0;
    public static final int doubleSolenoidShiftRighta = 4;
    public static final int doubleSolenoidShiftRightb = 3;
}
