// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
private CANSparkMax shooterMotor = new CANSparkMax(Constants.SHOOTER_PORT, MotorType.kBrushless);
private Servo gate = new Servo(Constants.GATE_PORT);


  public Shooter() {

  shooterMotor.restoreFactoryDefaults();
    gateClose();



  }
  public void stop(){
    shooterMotor.stopMotor();
    gateClose();
  }
  public void shooterMotorHigh (){
    shooterMotor.set(Constants.SHOOTER_HIGH_SPEED);
  }
  public void shooterMotorLow (){
    shooterMotor.set(Constants.SHOOTER_LOW_SPEED);
  }

  public void gateOpen (){
    gate.set(0);
  }
  private void gateClose() {
    gate.set(0.5);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
