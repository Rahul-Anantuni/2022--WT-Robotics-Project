// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {
  //Class Global VAriaables to store the Subsystem and Speed/Distance values
  //  provided during command creation through the Constructor
  private Drivetrain dt; //Stored drivetrain subsystem
  private double s;      //Stored Speed value
  private double d;      //Stored Distance to travel
  /** Creates a new DriveDistance. */
  public DriveDistance(Drivetrain drivetrain, double speed, double distance) {
      //Store the parameters in the Global Variables
      dt = drivetrain;
      s = speed;
      //To simplify comparison, only look at positive distances
      // d = distance;
      d = Math.abs(distance);

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Make sure the robot is not moving and the Encoder readings are at 0
    dt.resetEncoders();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Use Tank Drive method to drive straight forward
    dt.TeleopTankDrive(s, s);
    
    //Display Distance Reading on Smartboard for Debugging Purposes
    SmartDashboard.putNumber("EncoderDistance", dt.getAverageDistance());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stop the robot
    dt.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //Command is finished when Encoder reading is >= desired distance
    //Simplify by only comparing positive distances
    if ((dt.getAverageDistance() >= d)){
    //if ( (counter > 600)){
      return true;
    } else {
      return false;
    }
  }
}
