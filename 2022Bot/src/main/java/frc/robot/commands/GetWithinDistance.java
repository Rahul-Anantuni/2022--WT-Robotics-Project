// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class GetWithinDistance extends CommandBase {
  //Class Global VAriaables to store the Subsystem and Speed/Distance values
  //  provided during command creation through the Constructor
  private Drivetrain dt; //Stored drivetrain subsystem
  private double s;      //Stored Speed value
  private double d;      //Stored Distance to travel

  /** Creates a new GetWithinDistance. */
  public GetWithinDistance(Drivetrain drivetrain, double speed, double distance) {
    //Save the parameters in the Global Variables
    dt = drivetrain;
    s = speed;
    d = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Stop the Robot from moving
    dt.stop();
    //If we are to close, set speed to go in reverrse
    if (dt.getDistance() < d){
      s = -s;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Drive the robot at the desired speed using Tank Drive method
    dt.TeleopTankDrive(s, s);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stop the Robot
    dt.stop();
    //Reset the Global Speed to positive (Initial Condition)
    if (s < 0){
      s = -s;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //If the Robot is moving forward stop when sensor distance is <= d
    if (s > 0){
      return (dt.getDistance() <= d);
    //If the Robot is moving backward stop when sensor distance is >= d
    }else{
      return (dt.getDistance() >= d);
    }
  }
}