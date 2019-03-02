package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
public class DoubleSPunchSubsystem extends Subsystem {
  // Instantiation of double solenoid
  // PCM channels are in RobotMap
 
  DoubleSolenoid doubleS = new DoubleSolenoid(RobotMap.doubleSolenoid1, RobotMap.doubleSolenoid2);

  // "Punches" double solenoid outwards
  public void doublePunch(){
    doubleS.set(DoubleSolenoid.Value.kForward);
  }

  // Retracts double solenoid
  public void doubleRetract(){
    doubleS.set(DoubleSolenoid.Value.kReverse);
  }
  
  // Ensures no movement of double solenoid
  public void doubleIdle(){
    doubleS.set(DoubleSolenoid.Value.kOff);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
