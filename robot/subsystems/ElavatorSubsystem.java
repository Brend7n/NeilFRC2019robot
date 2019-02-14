
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

public class ElavatorSubsystem extends Subsystem {
  // Instantiation of speed controllers
  //CANBus port numbers are in RobotMap

  TalonSRX elavator = new TalonSRX(RobotMap.elavator);
  elavator.changeControlMode(ControlMode.PercentVbus); //Change control mode of talon, default is PercentVbus (-1.0 to 1.0)
  elavator.setPID(0.0, 0.0, 0.0); //Set the PID constants (p, i, d)
  elavator.enableControl(); //Enable PID control on the talon

  public void elavatorButtonControl(boolean direction, double speed){
    //true = forward, false = backwards (or vice versa depending on how the motors were connected)
    speed = Math.abs(speed);
    if(direction){
      elavator.set(ControlMode.PercentOutput, speed);
    }else{
      elavator.set(ControlMode.PercentOutput, -speed);
    }
  }

  public void stop(){
    elavator.neutralOutput();

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
