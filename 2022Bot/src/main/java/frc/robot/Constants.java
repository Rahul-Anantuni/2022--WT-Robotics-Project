package frc.robot;
public final class Constants {
    //Speeds 
    public static final double RAMP_RATE = 0.75;
    public static final double MAX_SPEED = 1.0;
    public static final double SHOOTER_HIGH_SPEED = -0.48 * 4900;
    public static final double SHOOTER_LOW_SPEED = -0.3* 5360;
    public static final double INTAKE_SPEED = 0.75;
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
    public static final int WINCH_PORT = 40;  //change to 42 for lift in a box

    public static final double ENCODER_PPR = 360.0/3.15; //360 CPR * pulses/rev
    public static final double WHEEL_DIAM = 7.5; //inches
    public static final double DIST_ADJUSTMENT = 5.0; 


}
