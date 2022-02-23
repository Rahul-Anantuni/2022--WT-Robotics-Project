// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  //Class Global Variables to store the Subsystem and Left/Right Speeds
  //  provided during command creation through the Constructor
  private Drivetrain DriveTrain; 
  private final DoubleSupplier leftSpeed;
  private final DoubleSupplier rightSpeed;
 
  /** Creates a new TankDrive. */
  public TankDrive(Drivetrain d, DoubleSupplier l, DoubleSupplier r) {
    //Save the parameters in the Global Variables
    DriveTrain = d;
    leftSpeed = l;
    rightSpeed = r;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Use Tank Drive to set speeds to current values
   //  Speeds are negated to account for Joystick forward values being negative
     DriveTrain.TeleopTankDrive(-leftSpeed.getAsDouble(), -rightSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stop the Robot from moving
    DriveTrain.stop();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //This is a default command, so should never end
    return false;
  }
}
