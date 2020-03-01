package frc.robot;

/*Class to provide place for robot-wide numerical or boolean constants.
Declare all constants globally.
Also, statically import the class/inner classes wherever the constants are needed, to reduce verbosity.
*/
public final class Constants {
    public final static double PI = 3.1415;
    public final static double CPWheelCircum = 25.1; //8P inches
    public final static double SpinWheel = 4.0;
    //---------------------------------------//

    //Used for OI
    public final static int JoystickPort = 0;
    public final static int AssistantJoystickPort = 1;
    //---------------------------------------//
    public final static int AButtonPort = 1;
    public final static int BButtonPort = 2;
    public final static int XButtonPort = 3;
    public final static int YButtonPort = 4;
    public final static int LBButtonPort = 5;
    public final static int RButtonPort = 6;
    public final static int StartButtonPort = 7;
    public final static int SelectButtonPort = 8;
    //---------------------------------------//
    public final static int LXStickAxisPort = 0;
    public final static int LYStickAxisPort = 1;
    public final static int LTAxisPort = 2;
    public final static int RTAxisPort = 3;
    public final static int RXStickAxisPort = 4;
    public final static int RYStickAxisPort = 5;

    //---------------------------------------//
    //CAN Items
    //Note to BMoney: Don't change these names here on
    //Drive Base                                        //Labels: A=right & B=left
    public final static int leftDriveTalonCAN = 1;      //B2
    public final static int rightDriveTalonCAN = 2;     //A2
    public final static int fLeftDriveVictorCAN = 3;    //B3
    public final static int fRightDriveVictorCAN = 4;   //A3
    public final static int bLeftDriveVictorCAN = 5;    //B4
    public final static int bRightDriveVictorCAN = 6;   //A4
    //Control Panel
    public final static int controlPanelCAN = 7;        //C7

    //Intake 
    public final static int intakeCAN = 8;              //C8
    public static final int PCMCAN = 41;                //No label.PCM CAN items are subject to change
    public static final int PDPCAN = 40;                //No Label
    public static final int leftIntakePiston = 0;
    public static final int rightIntakePiston = 1;

    //Shooter
    public final static int shooterCAN = 9;             //C1
    public final static int followerShooterCAN = 10;    //C5
    public static final int shooterPiston = 2;
    
    //Storage
    public final static int lstorageCAN = 11;           //C4
    public final static int rstorageCAN = 12;           //C3

    //Climb
    public final static int lclimbCAN = 13;             //B1
    public final static int rclimbCAN = 14;             //A1

    //---------------------------------------//
    public final static double driveSensitivity = 2.0; //bigger # means less sensitivity, from 0.5 to 2.0
    //10.0: baby speed, 9.0: tdddler mode, 7.0: fast toddler mode, 5.0: optimal turn speed, 4.5:
    public final static double turnSensitivity = 4.0; //4.5 seems nice
    public final static boolean isQuickTurn = true; //makes turning the drive base able to override constant-curvature turning for turn-in-place maneuvers.
    //Used for ...

    //Control Panel
    //---------------------------------------//
    public final static double cpRPMROT = 400; //test velocity variable (since gearbox screws with it) less means more for some stupid reason
    public final static double cpRPMPOS = 225; //test velocity variable (since gearbox screws with it) less means more for some stupid reason
    public final static double blueTargetMin = 0.4; //uses blue value
    public final static double redTargetMin = 0.5; //uses red value
    public final static double greenTargetMin = 0.55; //uses green value
    public final static double yellowGreenTargetMin = 0.5; //uses green value
    public final static double yellowRedTargetMax = 0.15; //uses red value
    public final static double rpmToPercentOutFactor = 0.07867; //DONOTCHANGEOHMAHGAHH

    //Intake
    //---------------------------------------//
    public final static double startingBallCount = 3.0;
    public final static double intakeVictorOutput = 0.3;
    public final static int intakeWaitTime = 10; //wait time in ms to see if the storage is full

    //Shooter
    //---------------------------------------//
    public final static int packetsAmnt = 180; //amount of packets gathered to find an average limelight value. Used for all types of limelight values. Packets should be in increments of ~18.
    //---------------------------------------//
    public final static double shooterAngle = 25.0; //angle of shooter in degrees of the horizontal (right now is (69.0 * PI) / 180 radians)
    public final static double towerHeight = 98.25; //height of power tower in inches
    public final static double limelightHeight = 10.5; //height of limelight in inches
    public final static double gravitationalAccel = 9.8; //acceleration due to gravity
    public final static double marginAngleError = 0.1; //amount in degrees that robot is allowed to be offset from target when shooting
    public final static double turnRate = 0.3; //turn speed based on percentage of drive base output
    public final static double veloError = 0.05; //amount of variance in m/s that the motor will allow to shoot
    public final static double currentShooterRadius = 3.0 * 0.0254; //radius of the shooter wheel (in meters) (0.2032 is conversion factor)
    public static long shootTriggerWaitTime = 800; //how long the pneumatics should wait until reseting (in ms)
    public final static double shooterF = 0.0; //F Val for shooter PID
    public final static double shooterP = 0.0; //... 
    public final static double shooterI = 0.0;
    public final static double shooterD = 0.0;
    public final static double limelightAngle = 28.0;


    //Storage
    //---------------------------------------//
    public final static double storageSpeed = 0.5; //speed of the belts in AMPS!!!
    public final static int pixyLEDBrightness = 255;
    public final static int storageWaitTime = 2000; //wait time to allow belt motors to continue for until it finds the target (in ms)

    //PID Control
    public final static int kPIDLoopIdx = 0;
    public final static double kTimeoutMs = 0;


}