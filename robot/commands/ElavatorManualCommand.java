
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElavatorManualCommand extends Command {

  // Constructor for intake (true) or outake (false) and
  // a motor speed value (0 to 1)
  public ElavatorManualCommand() {
    //requires(Robot.elavatorSubsystem);

  }

  // Ensures motors are stopped to avoid conflict
  @Override
  protected void initialize() {
    Robot.elavatorSubsystem.stop();
  }

  // Intakes or outtakes in the direction and speed given
  @Override
  protected void execute() {
    Robot.elavatorSubsystem.elavatorPercentOutput(Robot.m_oi.getOperatorStick().getRawAxis(3));
  }

  // Will only return true when  the command is cancelled
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // Stops the motors before exiting the program
  @Override
  protected void end() {
    Robot.elavatorSubsystem.stop();
  }

  // Only called when the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
  
