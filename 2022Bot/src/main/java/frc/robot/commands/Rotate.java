// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Rotate extends CommandBase {
  /** Creates a new Rotate. */
  Drivetrain d;
  double s;
  double a;

  public Rotate(Drivetrain drivetrain, double speed, double angle) {

    d = drivetrain;
    s = speed;
    a = angle;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d.gyroReset();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (a < 0){
      d.TeleopTankDrive(-s, s);
    }else{
      d.TeleopTankDrive(s, -s);
    }
  
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.TeleopTankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(d.getAngle()) >= Math.abs(a)){
      return true;
    }else{
    return false;
   }
  }
}
