// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoOne;
import frc.robot.commands.AutoTwo;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveToTarget;
import frc.robot.commands.DropIntake;
import frc.robot.commands.GateOpen;
import frc.robot.commands.GetWithinDistance;
import frc.robot.commands.GetWithinDistancePID;
import frc.robot.commands.IntakeOFF;
import frc.robot.commands.IntakeON;
import frc.robot.commands.IntakeReverse;
import frc.robot.commands.ReverseDrive;
import frc.robot.commands.Rotate;
import frc.robot.commands.RotatePID;
import frc.robot.commands.ShooterHigh;
import frc.robot.commands.ShooterLow;
import frc.robot.commands.ShooterStop;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TestAuto;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain() ; 
  private final Shooter m_shooter = new Shooter();
  private final Intake m_intake = new Intake();
  private final XboxController m_OperatorController = new XboxController(0); 
  private final Joystick m_DriverController = new Joystick(1); 
 // private final Joystick m_LeftJoystick = new Joystick(0);
  //private final Joystick m_RightJoystick = new Joystick(3);

  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    //ARCADE CONTROLLER
 /*  m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, 
                                                   ()->m_DriverController.getLeftY(),
                                                   ()->m_DriverController.getLeftX()));
    
*/
//TANK DRIVE CONTROLLER 
                   
  m_drivetrain.setDefaultCommand(new TankDrive(m_drivetrain, 
                                               ()->m_DriverController.getRawAxis(1),
                                             ()->m_DriverController.getRawAxis(3)));
      
  
  //ARCADE SINGLE JOYSTICK
  /*
         m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, 
                                                   ()->m_LeftJoystick.getY(),
                                                   ()->m_LeftJoystick.getZ()));
  */
  //TANK DRIVE JOYSTICKS
  /*
    m_drivetrain.setDefaultCommand(new TankDrive(m_drivetrain, 
                                                 ()->m_LeftJoystick.getY(),
                                                 ()->m_RightJoystick.getY()));
*/

  SmartDashboard.putNumber("Shooter Speed", 0.8);

  configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  /*final JoystickButton leftButton3 = new JoystickButton(m_LeftJoystick, 3);
    final JoystickButton rightButton3 = new JoystickButton(m_RightJoystick, 3);

    final JoystickButton rightButton4 = new JoystickButton(m_RightJoystick, 4);

    final JoystickButton rightButton6 = new JoystickButton(m_RightJoystick, 6);

    final JoystickButton rightButton11 = new JoystickButton(m_RightJoystick, 11);
    final JoystickButton rightButton12 = new JoystickButton(m_RightJoystick, 12);
    final JoystickButton rightButton9 = new JoystickButton(m_RightJoystick, 9);
    final JoystickButton rightButton10 = new JoystickButton(m_RightJoystick, 10);
   */ 
    
    //Controller Driver Buttons
    final JoystickButton DriverButton2 = new JoystickButton(m_DriverController, 2);
    final JoystickButton DriverButton1 = new JoystickButton(m_DriverController, 1);
    final JoystickButton DriverButton3 = new JoystickButton(m_DriverController, 3);
    final JoystickButton DriverButton4 = new JoystickButton(m_DriverController, 4);
    
    // Controller Operator Buttons
    final JoystickButton OperatorButton1  = new JoystickButton(m_OperatorController, 1);
    final JoystickButton OperatorButton2  = new JoystickButton(m_OperatorController, 2);
    final JoystickButton OperatorButton3  = new JoystickButton(m_OperatorController, 3);
    final JoystickButton OperatorButton4  = new JoystickButton(m_OperatorController, 4);
    final JoystickButton OperatorButton5  = new JoystickButton(m_OperatorController, 5);
    final JoystickButton OperatorButton6  = new JoystickButton(m_OperatorController, 6);
    final JoystickButton OperatorButton9  = new JoystickButton(m_OperatorController, 9);

    final JoystickButton OperatorButton10  = new JoystickButton(m_OperatorController, 10);
    final JoystickButton OperatorButton11  = new JoystickButton(m_OperatorController, 11);
    final JoystickButton OperatorButton12  = new JoystickButton(m_OperatorController, 12);

    
    DriverButton2.whenPressed(new ReverseDrive(m_drivetrain));
    DriverButton1.whenPressed(new RotatePID(m_drivetrain, 90));
    DriverButton3.whenInactive(new GetWithinDistancePID(m_drivetrain, 24));
    DriverButton4.whenPressed(new DriveToTarget(m_drivetrain));

    OperatorButton3.whenPressed(new ShooterLow(m_shooter));
    OperatorButton1.whenPressed(new GateOpen(m_shooter));
    OperatorButton2.whenPressed(new ShooterStop(m_shooter));
    OperatorButton4.whenPressed(new ShooterHigh(m_shooter));

    OperatorButton5.whenPressed(new IntakeON(m_intake));
    OperatorButton5.whenReleased(new IntakeOFF(m_intake));
    OperatorButton6.whenPressed(new IntakeReverse(m_intake));
    OperatorButton6.whenReleased(new IntakeOFF(m_intake));
    OperatorButton9.whenPressed(new DropIntake(m_drivetrain));
    OperatorButton10.whenPressed(new Rotate(m_drivetrain, 0.4, 180));

    OperatorButton11.whenPressed(new DriveDistance(m_drivetrain, 0.5, 32));
    OperatorButton12.whenPressed(new GetWithinDistance(m_drivetrain, 0.35, 35));

    m_chooser.setDefaultOption("AutoTwo", new AutoTwo(m_drivetrain, m_intake, m_shooter));
    m_chooser.addOption("AutoOne", new AutoOne(m_drivetrain, m_intake, m_shooter));
    SmartDashboard.putData(m_chooser);
    /*leftButton3.whenPressed(new ReverseDrive(m_drivetrain));
    rightButton3.whenPressed(new ReverseDrive(m_drivetrain));
    rightButton4.whenPressed(new DriveDistance(m_drivetrain, 0.5, 32));
    rightButton6.whenPressed(new GetWithinDistance(m_drivetrain, 0.5, 35));

    rightButton11.whenPressed(new ShooterHigh(m_shooter));
    rightButton12.whenPressed(new ShooterStop(m_shooter));
    rightButton9.whenPressed(new ShooterLow(m_shooter));
    rightButton10.whenPressed(new GateOpen(m_shooter));
      */
    


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
    //m_autoCommand;
  }

  public void RobotPeriodic(){
    SmartDashboard.putData(m_drivetrain);
  }
}
