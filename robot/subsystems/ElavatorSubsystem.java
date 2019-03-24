package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.RobotMap;

public class ElavatorSubsystem extends Subsystem {
  TalonSRX elavator = new TalonSRX(RobotMap.elavator);
  /*
  int currPos = 0;
  public int getCurrPos() {
    return currPos;
  }
  public void setCurrPos(int pos) {
    currPos = pos;
  }
  */
  public void talonSetup() {
  elavator.configFactoryDefault();
  elavator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  elavator.setSensorPhase(true);
  elavator.setInverted(true);
  elavator.setSelectedSensorPosition(0, 0, 30);

  }
  public void zeroEnc (){
    elavator.setSelectedSensorPosition(0, 0, 30);
  }

  public void elavatorPercentOutput(double power) {
    elavator.set(ControlMode.PercentOutput, power * 0.6);
  }

  public int getEncoderValue() {
    return elavator.getSelectedSensorPosition();
    
  }

  public void stop(){
    elavator.set(ControlMode.Disabled, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
