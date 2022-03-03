// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
  /** Creates a new Lift. */
  private CANSparkMax liftMotor = new CANSparkMax(Constants.LIFT_PORT, MotorType.kBrushless);
  private WPI_VictorSPX hookMotor = new WPI_VictorSPX (Constants.HOOK_PORT);


  public Lift() {

    liftMotor.restoreFactoryDefaults();
    hookMotor.configFactoryDefault();
  }


  public void liftUp() {
    liftMotor.set(Constants.LIFT_SPEED_UP);
  }
  public void liftDown () {
    liftMotor.set(-Constants.LIFT_SPEED_DOWN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
