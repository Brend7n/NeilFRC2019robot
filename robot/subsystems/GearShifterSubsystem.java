package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;
public class GearShifterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid doubleSRight = new DoubleSolenoid(RobotMap.doubleSolenoidShiftRighta, RobotMap.doubleSolenoidShiftRightb);
  DoubleSolenoid doubleSLeft = new DoubleSolenoid(RobotMap.doubleSolenoidShiftLefta, RobotMap.doubleSolenoidShiftLeftb);
  // "Punches" double solenoid outwards
  public void doubleShiftUp(){
    //forward is the first field in the constructor
    doubleSLeft.set(DoubleSolenoid.Value.kForward);
    doubleSRight.set(DoubleSolenoid.Value.kForward);
  }

  // Retracts double solenoid
  public void doubleShiftDown(){
    doubleSLeft.set(DoubleSolenoid.Value.kReverse);
    doubleSRight.set(DoubleSolenoid.Value.kReverse);
  }
  
  // Ensures no movement of double solenoid
  public void doubleIdle(){
    doubleSLeft.set(DoubleSolenoid.Value.kOff);
    doubleSRight.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
