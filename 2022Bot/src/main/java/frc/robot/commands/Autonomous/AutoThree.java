// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Drive.DriveDistancePID;
import frc.robot.commands.Shooter.GateClose;
import frc.robot.commands.Shooter.GateOpen;
import frc.robot.commands.Shooter.ShooterHigh;
import frc.robot.commands.Shooter.ShooterLow;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoThree extends SequentialCommandGroup {
  /** Creates a new AutoThree. */
  public AutoThree(Drivetrain drivetrain, Shooter shooter) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    super(
      sequence(
        new ShooterLow(shooter),
        new WaitCommand(3),
        new GateOpen(shooter),
        new WaitCommand(1),
        new GateClose(shooter),
        new DriveDistancePID(drivetrain, -48),
       // new DriveDistance(drivetrain, -.5, 48), //speed slower to get accurate reading(0.75)
        new ShooterHigh(shooter)

      )
    );

    addCommands();
  }
}
