// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class GetWithinDistancePID extends CommandBase {
  private PIDController distancePID = new PIDController(.3, 0, 0);
  private Drivetrain drive;
  private double distance;

  public GetWithinDistancePID(Drivetrain dt, double d) {
    // Use addRequirements() here to declare subsystem dependencies.
    distance = d;
    drive = dt;
    addRequirements(dt);

  }

  /** Creates a new GetWithinDistancePID. */
  public GetWithinDistancePID() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    distancePID.setSetpoint(distance);
    distancePID.setTolerance(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = MathUtil.clamp(distancePID.calculate(drive.getDistance()), -0.65, 0.65);
    SmartDashboard.putNumber("Speed", speed);
    if (!distancePID.atSetpoint()){
      if (Math.abs(speed)<0.40){
        speed = Math.signum(speed)*0.40;
      }
      drive.TeleopTankDrive(speed, speed);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return distancePID.atSetpoint();
  }
}
