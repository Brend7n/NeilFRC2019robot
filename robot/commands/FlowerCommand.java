package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FlowerCommand extends Command {
  // True direction indicates "punching," false indicates retracting
  // of the solenoid
  boolean direction = true;
  public FlowerCommand(boolean direction) {
    this.direction = direction;
    //requires(Robot.doubleSPunchSubsystem);
  }

  // Making sure the solenoid is not already moving before
  // executing the punch/retract
  @Override
  protected void initialize() {
    if(direction){
      Robot.doubleSPunchSubsystem.doublePunch();
    }else{
      Robot.doubleSPunchSubsystem.doubleRetract();
    }
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
