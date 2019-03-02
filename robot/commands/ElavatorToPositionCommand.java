package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ElavatorToPositionCommand extends Command {

  int targetPos;
  int targetPosNum;
  double desiredPower = 0.0;
  public ElavatorToPositionCommand(int targetPos) {
    this.targetPos = targetPos;
    requires(Robot.elavatorSubsystem);
    //setTimeout(6);
  }
  @Override
  protected void initialize() {
    
    if (targetPos == 0) {
      targetPosNum = RobotMap.lowElavatorPosition;
       
    }
    if (targetPos == 1) {
      targetPosNum = RobotMap.medElavatorPosition;
    }
    if (targetPos == 2) {
      targetPosNum = RobotMap.highElavatorPosition;
    }
    
  }
  @Override
  protected void execute() {
  
    if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())>RobotMap.highSpeedPositionRange) desiredPower = 1;
    else if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())<RobotMap.highSpeedPositionRange) desiredPower = -1;
    else if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())>RobotMap.medSpeedPositionRange) desiredPower = 0.5;
    else if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())<RobotMap.medSpeedPositionRange) desiredPower = -0.5;
    else if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())>RobotMap.lowSpeedPositionRange) desiredPower = 0.2;
    else if ((targetPosNum-Robot.elavatorSubsystem.getEncoderValue())<RobotMap.lowSpeedPositionRange) desiredPower = -0.2;
    else desiredPower = 0;
    Robot.elavatorSubsystem.elavatorPercentOutput(desiredPower);
  }
  @Override
  protected boolean isFinished() {
    //dead band -0.1 < x < 0.1
    if (Robot.m_oi.getOperatorStick().getRawAxis(3) > -0.1 && Robot.m_oi.getOperatorStick().getRawAxis(3) < 0.1) {
      return true;
    } else {
      if (desiredPower < 0.2 && desiredPower > -0.2) {
        return true;
      } else {
        return false;
      }
    }
    
  }
  @Override
  protected void end() {
      Robot.elavatorSubsystem.stop();
  }

  // Ends the command if the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
