package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;

public class IntakeSubsystem extends Subsystem {
	// Victor speed controller instantiations
	//RobotMap has CANBus ports
	
	Victor intakeMotor = new Victor(RobotMap.intake);

	SpeedController intakeController = new SpeedControllerGroup(intakeMotor);
	public IntakeSubsystem() {
		// Setting inversions (flipped direction of motor)
		// of speed controllers
		intakeController.setInverted(false);
	}
	// Drives drivetrain based on joystick input and dampening value (speed)
	// from 0 to 1
	public void driveJoystick(Joystick joystick, double speed) {
		intakeController.set(joystick.getRawAxis(1) *speed );
	}

	// Stops the motors on the drivetrain
	public void stop() {
		intakeController.stopMotor();
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
