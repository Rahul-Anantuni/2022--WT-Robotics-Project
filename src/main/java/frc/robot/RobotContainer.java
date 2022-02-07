// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.GetWithinDistance;
import frc.robot.commands.ReverseDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain() ; 

  //private final XboxController m_Controller = new XboxController(0); 
  private final Joystick m_LeftJoystick = new Joystick(0);
  private final Joystick m_RightJoystick = new Joystick(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
   /* m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, 
                                                   ()->m_Controller.getLeftY(),
                                                   ()->m_Controller.getLeftX()));
  */
    m_drivetrain.setDefaultCommand(new TankDrive(m_drivetrain, 
                                                 ()->m_LeftJoystick.getY(),
                                                 ()->m_RightJoystick.getY()));
  
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton leftButton3 = new JoystickButton(m_LeftJoystick, 3);
    final JoystickButton rightButton3 = new JoystickButton(m_RightJoystick, 3);

    final JoystickButton rightButton4 = new JoystickButton(m_RightJoystick, 4);

    final JoystickButton rightButton6 = new JoystickButton(m_RightJoystick, 6);

    leftButton3.whenPressed(new ReverseDrive(m_drivetrain));
    rightButton3.whenPressed(new ReverseDrive(m_drivetrain));
    rightButton4.whenPressed(new DriveDistance(m_drivetrain, 0.5, 32));
    rightButton6.whenPressed(new GetWithinDistance(m_drivetrain, 0.5, 35));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;//m_autoCommand;
  }
}