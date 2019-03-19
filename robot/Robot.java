package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElavatorManualCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DoubleSPunchSubsystem;
import frc.robot.subsystems.GearShifterSubsystem;
import frc.robot.subsystems.ElavatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Robot extends TimedRobot {
  //instantiating subsytems
  public static OI m_oi;
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static DoubleSPunchSubsystem doubleSPunchSubsystem = new DoubleSPunchSubsystem();//flower
  public static GearShifterSubsystem gearShifterSubsystem = new GearShifterSubsystem();
  public static ElavatorSubsystem elavatorSubsystem = new ElavatorSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  //for commands that run all the time because they keep polling the axis of the controllers
  Command intakeCommand = new IntakeCommand();
  Command driveCommand = new DriveCommand();
  Command elavatorManualCommand = new ElavatorManualCommand();
  Compressor compressor = new Compressor();
  //camera stuff
  CameraServer server0 = CameraServer.getInstance();
  CameraServer server1 = CameraServer.getInstance();
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    elavatorSubsystem.talonSetup();

    server0.startAutomaticCapture();
    server1.startAutomaticCapture(1);
    
  }
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   */
  @Override
  public void robotPeriodic() {}
  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    elavatorSubsystem.zeroEnc();
    driveCommand.start();
    intakeCommand.start();
    elavatorManualCommand.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    driveCommand.start();
    intakeCommand.start();
    compressor.stop();
    elavatorManualCommand.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("encoder: ", Robot.elavatorSubsystem.getEncoderValue() );
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
