

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.RobotMap;

public class ElavatorSubsystem extends Subsystem {
  // Instantiation of speed controllers CANBus port numbers are in RobotMap
  //final Gains kGains = new Gains(kP 0.2, kI 0.0, kD 0.0, kF 0.2, kIzone 0, kPeakOutput 1.0);
  public int currentElavatorPosition;

  TalonSRX elavator = new TalonSRX(RobotMap.elavator);
  public void talonSetup() {
  elavator.configFactoryDefault();
  elavator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  
  elavator.setSensorPhase(true);
  elavator.setInverted(false);

  elavator.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
  elavator.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 30);

  elavator.selectProfileSlot(0, 0);
	elavator.config_kF(0, 0.2, 30);
	elavator.config_kP(0, 0.2, 30);
	elavator.config_kI(0, 0.0, 30);
  elavator.config_kD(0, 0.0, 30);
  
  elavator.configMotionCruiseVelocity(15000, 30);
  elavator.configMotionAcceleration(6000, 30);
  
  elavator.setSelectedSensorPosition(0, 0, 30);
  }
  
  
  /*  //(public void elavatorButtonControl(boolean direction, double speed){
    //true = forward, false = backwards (or vice versa depending on how the motors were connected)
    speed = Math.abs(speed);
    if(direction){
      elavator.set(ControlMode.PercentOutput, speed);
    }else{
      elavator.set(ControlMode.PercentOutput, -speed);
    }
  }*/

  public void setElavatorPosition(int targetPos) {
    
    if (targetPos == 0) elavator.set(ControlMode.MotionMagic, RobotMap.lowElavatorPosition);
    if (targetPos == 1) elavator.set(ControlMode.MotionMagic, RobotMap.medElavatorPosition);
    if (targetPos == 2) elavator.set(ControlMode.MotionMagic, RobotMap.highElavatorPosition);
    currentElavatorPosition = targetPos;
  }

  public void changeElavatorPosition(boolean upOrDown) {
    int targetPos = currentElavatorPosition;
    if (upOrDown) {
      targetPos += 1;
    } else {
      targetPos -= 1;
    }
    if (targetPos >= 0 && targetPos <= RobotMap.elavatorMax ) {
      if (targetPos == 0) elavator.set(ControlMode.MotionMagic, RobotMap.lowElavatorPosition);
      if (targetPos == 1) elavator.set(ControlMode.MotionMagic, RobotMap.medElavatorPosition);
      if (targetPos == 2) elavator.set(ControlMode.MotionMagic, RobotMap.highElavatorPosition);
      currentElavatorPosition = targetPos;
    }
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
