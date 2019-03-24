package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
public class PistonSubsystem extends Subsystem {
  // Instantiation of double solenoid
  // PCM channels are in RobotMap
 
  DoubleSolenoid doubleS = new DoubleSolenoid(RobotMap.doubleSolenoid1a, RobotMap.doubleSolenoid1b);
  DoubleSolenoid doubleS2 = new DoubleSolenoid(RobotMap.doubleSolenoid2a, RobotMap.doubleSolenoid2b);
  boolean direction = false;
  public void changeDS() {
    if (direction) {
      doubleS.set(DoubleSolenoid.Value.kForward);
      direction = false;
    } else {
      doubleS.set(DoubleSolenoid.Value.kReverse);
      direction = true;
    }
  }

  public void changeDS2() {
    if (direction) {
      doubleS2.set(DoubleSolenoid.Value.kForward);
      direction = false;
    } else {
      doubleS2.set(DoubleSolenoid.Value.kReverse);
      direction = true;
    }
  }

  // "Punches" double solenoid outwards
  public void doublePunch(){
    doubleS.set(DoubleSolenoid.Value.kForward);
    doubleS2.set(DoubleSolenoid.Value.kForward);
  }

  // Retracts double solenoid
  public void doubleRetract(){
    doubleS.set(DoubleSolenoid.Value.kReverse);
    doubleS2.set(DoubleSolenoid.Value.kReverse);
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
