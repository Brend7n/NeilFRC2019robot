package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ElavatorToPositionCommand extends Command {

  int targetPos;
  
  public ElavatorToPositionCommand(int targetPos) {
    this.targetPos = targetPos;
    requires(Robot.elavatorSubsystem);
  }
  @Override
  protected void initialize() {
    Robot.elavatorSubsystem.setElavatorPosition(targetPos);
  }
  @Override
  protected void execute() {
    
  }
  @Override
  protected boolean isFinished() {
    return true;
  }
  @Override
  protected void end() {
      //Robot.elavatorSubsystem.stop();
  }

  // Ends the command if the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
