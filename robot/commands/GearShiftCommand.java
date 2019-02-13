package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GearShiftCommand extends Command {
// True direction indicates "punching," false indicates retracting
  // of the solenoid
  boolean direction = true;

  public GearShiftCommand(boolean direction) {
    this.direction = direction;
    //requires(Robot.gearShifterSubsystem);
  }

  // Making sure the solenoid is not already moving before
  // executing the punch/retract
  @Override
  protected void initialize() {
    if(direction){
      Robot.gearShifterSubsystem.doubleShiftUp();
    }else{
      Robot.gearShifterSubsystem.doubleShiftDown();
    }
    //Robot.gearShifterSubsystem.doubleIdle();
  }

  // Takes in the boolean from the constructor to punch or retract
  @Override
  protected void execute() {
    
  }

  // Returns true immediately so execute only runs once
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Ensures that the solenoid does not continue to move
  @Override
  protected void end() {
    Robot.gearShifterSubsystem.doubleIdle();
  }

  // Ends the command in case of interruption
  @Override
  protected void interrupted() {
    end();
  }
}
