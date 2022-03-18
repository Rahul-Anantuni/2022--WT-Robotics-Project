// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class RotatePID extends CommandBase {
  /** Creates a new RotatePID. */
  private PIDController anglePID = new PIDController(.015, 0, 0.001);
  private Drivetrain drive;
  private double angle;

  public RotatePID(Drivetrain dt, double a) {
    // Use addRequirements() here to declare subsystem dependencies.
    angle = a;
    drive = dt;
    addRequirements(dt);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  anglePID.setSetpoint(angle);
  anglePID.setTolerance(0.25);
  drive.gyroReset();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = MathUtil.clamp(anglePID.calculate(drive.getAngle()), -0.7, 0.7);
    SmartDashboard.putNumber("Gyro Speed", speed);
    if (!anglePID.atSetpoint()){
      if (Math.abs(speed)<0.40){
        speed = Math.signum(speed)*0.40;
      }
      drive.TeleopTankDrive(-speed, speed);
    }
    SmartDashboard.putNumber("Gyro", drive.getAngle());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.TeleopTankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return anglePID.atSetpoint();
  }
}
