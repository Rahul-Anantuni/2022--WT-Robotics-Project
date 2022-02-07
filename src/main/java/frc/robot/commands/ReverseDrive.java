// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ReverseDrive extends InstantCommand {
  //Class Global VAriaables to store the Subsystem value
  //  provided during command creation through the Constructor
  private Drivetrain dt;

  public ReverseDrive(Drivetrain drivetrain) {
    //Save the parameters in the Global Variables
    dt = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Call Drivetrain Method to toggle the robot front/back
    dt.reverse();
  }
}