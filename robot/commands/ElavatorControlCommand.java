
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElavatorControlCommand extends Command {
  Boolean direction = false;

  // Constructor for intake (true) or outake (false) and
  // a motor speed value (0 to 1)
  public ElavatorControlCommand(boolean direction) {
    this.direction = direction;
  }

  // Ensures motors are stopped to avoid conflict
  @Override
  protected void initialize() {
    Robot.elavatorSubsystem.elavatorButtonControl(direction, 0.8);
  }

  // Intakes or outtakes in the direction and speed given
  @Override
  protected void execute() {
    
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
  
