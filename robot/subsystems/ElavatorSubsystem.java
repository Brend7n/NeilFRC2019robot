
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

public class ElavatorSubsystem extends Subsystem {
  // Instantiation of speed controllers
  //CANBus port numbers are in RobotMap

  Victor elavator = new Victor(RobotMap.elavator);

  //Groups speed controllers together
  SpeedController elavatorController = new SpeedControllerGroup(elavator);

  // encoder instantiation
  Encoder enc = new Encoder(RobotMap.enc1a, RobotMap.enc1b, false, Encoder.EncodingType.k4X);

  public void elavatorButtonControl(boolean direction, double speed){
    //true = forward, false = backwards (or vice versa depending on how the motors were connected)
    speed = Math.abs(speed);
    if(direction){
      elavatorController.set(speed);
    }else{
      elavatorController.set(-speed);
    }
  }

  public void stop(){
    elavatorController.stopMotor();
  }

  // Gets a Raw encoder value
	// Similarly, getCount will give you the number of 
	// "clicks" it has recorded
	public double getEncRaw(){
		return enc.getRaw();
	}
/*
	// Gets a distance based on a factor for units per
	// encoder value
	// Units used is up to the team
	public double getEncDistance(){
		return getEncRaw() * 0.0008;
	}
*/
	//Resets the encoders so that they read from 0 again
	public void encReset(){
		enc.reset();
	}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
