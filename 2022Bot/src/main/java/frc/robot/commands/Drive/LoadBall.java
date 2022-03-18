// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class LoadBall extends CommandBase {
  /** Creates a new DropIntake. */
  Drivetrain d;
  int counter;

  public LoadBall(Drivetrain drivetrain) {
    d = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    d.setRampRate(0.0);
    counter = 0;
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(counter < 3){
      d.TeleopTankDrive(-0.5, -0.5);
    }else{
      d.TeleopTankDrive(0.5, 0.5);
    }
    counter++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.TeleopTankDrive(0, 0);
    d.setRampRate(Constants.RAMP_RATE);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (counter >= 7 ){
      return true;
    }else{
    return false;
  }
}
}
