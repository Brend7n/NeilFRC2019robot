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
import frc.robot.commands.ElavatorIteratePosCommand;
public class OI {
	// Instantiaion of joysticks
	Joystick driverStick = new Joystick(0);
	//Joystick operatorStick = new Joystick(1);
  // Instantiation of buttons with names based on their associated commands
	JoystickButton doublePunch = new JoystickButton(driverStick, 1);
  JoystickButton doubleRetract = new JoystickButton(driverStick, 2);
  
  JoystickButton doubleShiftUp = new JoystickButton(driverStick, 3);
  JoystickButton doubleShiftDown = new JoystickButton(driverStick, 4);

  JoystickButton elavatorUp = new JoystickButton(driverStick, 7);
  JoystickButton elavatorDown = new JoystickButton(driverStick, 8);
	// Joystick accessors 
	public Joystick getDriverStick() {
		return driverStick;
	}
  
	public OI(){
		// Associating commands with buttons
		doublePunch.whileHeld(new DoubleSPunchCommand(true));
    doubleRetract.whileHeld(new DoubleSPunchCommand(false));
    
    doubleShiftUp.whileHeld(new GearShiftCommand(true));
    doubleShiftDown.whileHeld(new GearShiftCommand(false));

   elavatorUp.whenPressed(new ElavatorIteratePosCommand(true));
   elavatorDown.whenPressed(new ElavatorIteratePosCommand(false));
	}
/*  //// CREATING BUTTONS
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // button.whenPressed(new ExampleCommand());

  // button.whileHeld(new ExampleCommand());

  // button.whenReleased(new ExampleCommand());
*/
}
