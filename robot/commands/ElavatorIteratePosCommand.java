//changeElavatorPosition
package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ElavatorIteratePosCommand extends Command {
  boolean upOrDown;
  public ElavatorIteratePosCommand(boolean upOrDown) {
    this.upOrDown = upOrDown;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elavatorSubsystem);
  }

  @Override
  protected void initialize() {
    Robot.elavatorSubsystem.changeElavatorPosition(upOrDown);
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

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
