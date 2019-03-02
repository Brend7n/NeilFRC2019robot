
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class IntakeCommand extends Command {
  public IntakeCommand() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.driveSubsystem);
  }

 // Ensures motors aren't already moving 
 @Override
 protected void initialize() {
   Robot.intakeSubsystem.stop();
 }

 // Uses the driver joystick to control the drive train with
 //speed damper , speed modifier , change motor speed
 @Override
 protected void execute() {
   Robot.intakeSubsystem.driveJoystick(Robot.m_oi.getOperatorStick(), 0.9);
 }

 // Will only return true if the command is cancelled
 @Override
 protected boolean isFinished() {
   return false;
 }

 // Stops the motors
 @Override
 protected void end() {
   Robot.intakeSubsystem.stop();
 }

 // Ends when the command is interrupted
 @Override
 protected void interrupted() {
   end();
 }
}
