package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
  /** Creates a new Lift. */
  private CANSparkMax winchMotor = new CANSparkMax(Constants.WINCH_PORT, MotorType.kBrushless);
  private WPI_VictorSPX liftMotor = new WPI_VictorSPX (Constants.LIFT_PORT);

  public Lift() {
    liftMotor.configFactoryDefault();
    winchMotor.restoreFactoryDefaults();
  }

  public void liftUp() {
    liftMotor.set(Constants.LIFT_SPEED_UP);
  }
  public void liftDown () {
    liftMotor.set(-Constants.LIFT_SPEED_DOWN);
  }
  public void winchUp() {
    winchMotor.set(Constants.WINCH_SPEED);
  }
  public void winchDown() {
    winchMotor.set(-Constants.WINCH_SPEED);
  }
  public void liftStop(){
    liftMotor.set(0);
  }
  public void winchStop(){
    winchMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Winch Output Current", winchMotor.getOutputCurrent());
  }
}
