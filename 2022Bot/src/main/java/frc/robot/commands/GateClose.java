// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class GateClose extends InstantCommand {
  /** Creates a new GateClose. */
  private Shooter g;

  public GateClose(Shooter gate) {
    // Use addRequirements() here to declare subsystem dependencies.
    g = gate;
    addRequirements(gate);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    g.gateClose();
  }

}
