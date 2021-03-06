package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PistonCommand extends Command {
  // True direction indicates "punching," false indicates retracting
  // of the solenoid
  public PistonCommand() {
    
    //requires(Robot.doubleSPunchSubsystem);
  }

  // Making sure the solenoid is not already moving before
  // executing the punch/retract
  @Override
  protected void initialize() {
    Robot.pistonSubsystem.changeDS();
    //Robot.doubleSPunchSubsystem.doubleIdle();
  }

  // Takes in the boolean from the constructor to punch or retract
  @Override
  protected void execute() {
    
  }

  // Returns true immediately so execute only runs once
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Ensures that the solenoid does not continue to move
  @Override
 protected void end() {
//  Robot.doubleSPunchSubsystem.doubleIdle();
  }

  // Ends the command in case of interruption
  @Override
  protected void interrupted() {
    end();
  }
}
