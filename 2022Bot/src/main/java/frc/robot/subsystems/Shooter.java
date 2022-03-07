// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
private CANSparkMax shooterMotor = new CANSparkMax(Constants.SHOOTER_PORT, MotorType.kBrushless);
private Servo gate = new Servo(Constants.GATE_PORT);

private RelativeEncoder shooterEncoder = shooterMotor.getEncoder();
private SparkMaxPIDController m_pidController = shooterMotor.getPIDController();

  public Shooter() {
    shooterMotor.restoreFactoryDefaults();
    shooterMotor.setIdleMode(IdleMode.kBrake);

    shooterMotor.setOpenLoopRampRate(0.08);
    shooterMotor.setClosedLoopRampRate(0.08);
    shooterMotor.setSmartCurrentLimit(60);
    gateClose();

    m_pidController.setP(0.00095);
    m_pidController.setI(0);
    m_pidController.setD(0.00001);
    m_pidController.setIZone(0);
    m_pidController.setFF(0.0);//(0.000015);
    m_pidController.setOutputRange(-1,1);




  }
  public void stop(){
    
    m_pidController.setReference(0, CANSparkMax.ControlType.kVelocity);
    shooterMotor.stopMotor();
    gateClose();
  }
  public void shooterMotorHigh (){
    //setVelocity(Constants.SHOOTER_HIGH_SPEED);
  //  double s = SmartDashboard.getNumber("Shooter Speed", 0.5);
   shooterMotor.set(-Constants.SHOOTER_HIGH_SPEED);
    //shooterMotor.set(-s);


  }
  public void shooterMotorLow (){
    //setVelocity(Constants.SHOOTER_LOW_SPEED);
    shooterMotor.set(-Constants.SHOOTER_LOW_SPEED);
    

  }

  public void gateOpen (){
    gate.set(0.7);
  }
  public void gateClose() {
    gate.set(0.0);
  }
  public void gateSet(double angle){
    gate.set(angle);
  }
  public void setVelocity(double velocity){
   m_pidController.setReference(velocity, CANSparkMax.ControlType.kVelocity);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Servo Location", gate.getAngle());
    
    SmartDashboard.putNumber("Shooter Temperature", shooterMotor.getMotorTemperature());
    SmartDashboard.putNumber("Shooter Output Current", shooterMotor.getOutputCurrent());

    SmartDashboard.putNumber("Shooter Velocity", shooterEncoder.getVelocity());
    if (shooterEncoder.getVelocity() > 0){
      if(shooterMotor.getMotorTemperature() > 140){
        stop();
      }
    }
  }
}
