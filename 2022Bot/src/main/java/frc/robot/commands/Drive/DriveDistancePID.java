// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistancePID extends CommandBase {
  private Drivetrain dt; //Stored drivetrain subsystem
  private double s = 0;      //Stored Speed value
  private double d;      //Stored Distance to travel
  private PIDController distancePID = new PIDController(.035, 0, 0.001);//(0.075, 0, 0.01);

  /** Creates a new DriveDistance. */
  public DriveDistancePID(Drivetrain drivetrain, double distance) {
      //Store the parameters in the Global Variables
      dt = drivetrain;
      //To simplify comparison, only look at positive distances
      // d = distance;
      d = distance;
      addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.resetEncoders();
    distancePID.setSetpoint(d);
    distancePID.setTolerance(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s = MathUtil.clamp(distancePID.calculate(dt.getAverageDistance()),-0.8 , 0.8);
    if (!distancePID.atSetpoint()){
      if (Math.abs(s) < 0.5){
        s = Math.signum(s) * 0.5;
      }
    }
    dt.TeleopTankDrive(s, s);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (distancePID.atSetpoint());
  }
}
