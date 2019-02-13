package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ElavatorToPositionCommand extends Command {

  DriveCommand driveCommand = new DriveCommand();

  double distance = 0.0;
  double speed = 0.0;

  // Distance and speed values in constructor 
  // Distance depends on your distance factor in your subsystem
  // Speed is the -1 to 1 value given to your motors

  public ElavatorToPositionCommand(double distance, double speed) {

    this.distance = distance;
    this.speed = speed;
      
  }

  // Resets the encoders to read 0 and stops motors to ensure no prior
  // movement
  @Override
  protected void initialize() {
      Robot.elavatorSubsystem.stop();
      Robot.elavatorSubsystem.encReset();
      driveCommand.cancel();
  }

  // Drives forward (no rotation) until isFinshed returns true
  @Override
  protected void execute() {
    Robot.elavatorSubsystem.elavatorButtonControl(true, 0.7);
  }

  // Returns true when the error between the desired distance and 
  // the encoder distance is less than or equal to 0.1
  // 0.1 is a dummy value and may differ depending on the application 
  // of the command
  @Override
  protected boolean isFinished() {
    return Math.abs(Robot.elavatorSubsystem.getEncRaw() - distance) <= 0.1;
  }

  // Stops the motors once isFinished returns true before
  // exiting the program
  @Override
  protected void end() {
      Robot.elavatorSubsystem.stop();
      //Robot.elavatorControlCommand.start();
  }

  // Ends the command if the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}