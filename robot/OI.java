package frc.robot;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.Robot;
import frc.robot.commands.DoubleSPunchCommand;
import frc.robot.commands.GearShiftCommand;
public class OI {
	// Instantiaion of joysticks
	Joystick driverStick = new Joystick(0);
	Joystick operatorStick = new Joystick(1);
  // Instantiation of buttons with names based on their 
	// associated commands
	JoystickButton doublePunch = new JoystickButton(driverStick, 1);
  JoystickButton doubleRetract = new JoystickButton(driverStick, 2);
  
  JoystickButton doubleShiftUp = new JoystickButton(driverStick, 3);
	JoystickButton doubleShiftDown = new JoystickButton(driverStick, 4);

	// Joystick accessors

	public Joystick getDriverStick() {
		return driverStick;
	}

  /*	public Joystick getOperatorStick() {
		return operatorStick;
	}
	*/
	public OI(){

		// Associating commands with buttons
		doublePunch.whenPressed(new DoubleSPunchCommand(true));
    doubleRetract.whenPressed(new DoubleSPunchCommand(false));
    
    doubleShiftUp.whenPressed(new GearShiftCommand(true));
    doubleShiftDown.whenPressed(new GearShiftCommand(false));
	}
/*  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
*/
}
