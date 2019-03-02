package frc.robot;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.Robot;
import frc.robot.commands.FlowerCommand;
import frc.robot.commands.GearShiftCommand;
//import frc.robot.commands.ElavatorManualCommand;
import frc.robot.commands.ElavatorToPositionCommand;
public class OI {
	// Instantiaion of joysticks
	Joystick driverStick = new Joystick(0);
  Joystick operatorStick = new Joystick(1);
  
  // Instantiation of buttons with names based on their associated commands
  // gear shift on the flight stick
  JoystickButton doubleShiftUp = new JoystickButton(driverStick, 1);
  JoystickButton doubleShiftDown = new JoystickButton(driverStick, 2);

  //flower on the gamepad  
  JoystickButton doublePunch = new JoystickButton(operatorStick, 7);
  JoystickButton doubleRetract = new JoystickButton(operatorStick, 8);

  //elavator setting positions
  JoystickButton elavatorLow = new JoystickButton(operatorStick, 1);
  JoystickButton elavatorMedium = new JoystickButton(operatorStick, 2);
  JoystickButton elavatorHigh = new JoystickButton(operatorStick, 3);

	// Joystick accessors 
	public Joystick getDriverStick() {
		return driverStick;
  }
  public Joystick getOperatorStick() {
		return operatorStick;
	}
  
	public OI(){
		// Associating commands with buttons
		doublePunch.whileHeld(new FlowerCommand(true));
    doubleRetract.whileHeld(new FlowerCommand(false));
    
    doubleShiftUp.whileHeld(new GearShiftCommand(true));
    doubleShiftDown.whileHeld(new GearShiftCommand(false));

   //elavatorManualUp.whenPressed(new ElavatorControlCommand(true));
   //elavatorManualDown.whenPressed(new ElavatorControlCommand(false));

    elavatorLow.whenPressed(new ElavatorToPositionCommand(0));
    elavatorMedium.whenPressed(new ElavatorToPositionCommand(1));
    elavatorHigh.whenPressed(new ElavatorToPositionCommand(2));
  }
/*  //// CREATING BUTTONS
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  // button.whenPressed(new ExampleCommand());
  // button.whileHeld(new ExampleCommand());
  // button.whenReleased(new ExampleCommand());
*/
}
