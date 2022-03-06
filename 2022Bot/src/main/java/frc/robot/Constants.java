// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Speeds 
    public static final double RAMP_RATE = 0.75;
    public static final double MAX_SPEED = 0.88;
    public static final double SHOOTER_HIGH_SPEED = 0.5;
    public static final double SHOOTER_LOW_SPEED = 0.40;//.4 * 5700;
    public static final double INTAKE_SPEED = 0.85;
    public static final double LIFT_SPEED_UP = 1;
    public static final double LIFT_SPEED_DOWN = 1;
    public static final double WINCH_SPEED = 0.70;

    //Can bus addresses for Drivetrain Motors
    public static final int TOP_LEFT   = 10; 
    public static final int BOTTOM_LEFT  = 11;
    public static final int TOP_RIGHT    = 20; 
    public static final int BOTTOM_RIGHT = 21;
    // PORTS
    public static final int encoder_LeftA = 6;
    public static final int encoder_RightA = 8;
    public static final int encoder_LeftB = 7;
    public static final int encoder_RightB = 9;
    public static final int SHOOTER_PORT = 31;
    public static final int INTAKE_PORT = 30;
    public static final int GATE_PORT = 0; //pwm
    public static final int ULTRASONIC_PORT = 0;
    public static final int GYRO_PORT = 1;
    public static final int LIFT_PORT = 41;
    public static final int WINCH_PORT = 40;

    public static final double ENCODER_PPR = 360.0; //360 CPR * pulses/rev
    public static final double WHEEL_DIAM = 7.5; //inches
    public static final double DIST_ADJUSTMENT = 5.0; 


}
