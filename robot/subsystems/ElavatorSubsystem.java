
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.RobotMap;

public class ElavatorSubsystem extends Subsystem {
  // Instantiation of speed controllers
  //CANBus port numbers are in RobotMap

  Victor elavator = new Victor(RobotMap.elavator);

  //Groups speed controllers together
  SpeedController elavatorController = new SpeedControllerGroup(elavator);

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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
