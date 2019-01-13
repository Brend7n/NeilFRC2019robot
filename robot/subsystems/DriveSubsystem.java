package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends Subsystem {
   // Put methods for controlling this subsystem
    // here. Call these from Commands.

	// Victor speed controller instantiations
	//RobotMap has CANBus ports
	
	Victor frontRight = new Victor(RobotMap.frontRight);
	Victor middleRight = new Victor(RobotMap.middleRight);
	Victor backRight = new Victor(RobotMap.backRight);
	Victor frontLeft = new Victor(RobotMap.frontLeft);
	Victor middleLeft = new Victor(RobotMap.middleLeft);
	Victor backLeft = new Victor(RobotMap.backLeft);
/*
	// Sample PWM motor instantiation
	
	PWM motor = new PWM(1);
*/	
	// Groups left and right speed controllers together for drivetrain

	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, middleLeft, backLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight, middleRight, backRight);
	// Initial instantiation of our drivetrain object 
	public DifferentialDrive drive;

	
	public DriveSubsystem() {

		// Setting inversions (flipped direction of motor)
		// of speed controllers
		
		frontRight.setInverted(false);
		frontLeft.setInverted(false);
		middleRight.setInverted(false);
		middleLeft.setInverted(false);
		backRight.setInverted(false);
		backLeft.setInverted(false);

		// Finalising instantiation of the drivetrain object
		// after setting motor inversions
		
		drive = new DifferentialDrive(left, right);
	}
	// Drives drivetrain based on joystick input and dampening value (speed)
	// from 0 to 1
	public void driveJoystick(Joystick joystick, double speed) {
		
		drive.arcadeDrive(joystick.getY()*speed, joystick.getX()*speed);
	}
	
	// Drives drivetrain based on given speed and roation values
	public void drive(double speed, double rotationSpeed) {
		drive.arcadeDrive(speed, rotationSpeed);
	}

	// Stops the motors on the drivetrain
	public void stop() {
		drive.stopMotor();
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
