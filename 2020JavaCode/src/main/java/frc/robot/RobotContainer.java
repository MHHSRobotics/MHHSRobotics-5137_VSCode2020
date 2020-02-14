package frc.robot;

import java.util.function.BooleanSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ControlPanel_Command;
import frc.robot.commands.Intake_Command;
import frc.robot.commands.Shoot_Command;
import frc.robot.subsystems.Climb_Subsystem;
import frc.robot.subsystems.ControlPanel_Subsystem;
import frc.robot.subsystems.DriveBase_Subsystem;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.Shooter_Subsystem;
import frc.robot.subsystems.Storage_Subsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 * 
 * If you aren't familiar with this (since this is new to this year), this is a
 * combination of OI.java and RobotMap.java, both of which are gone this this
 * year into this class. If desired, this class can be subdivided back into the
 * previous two files.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    // Commands go here...

    // Subsystems (actual object name, not class names)
    public static Climb_Subsystem climb_Subsystem;
    public static ControlPanel_Subsystem controlPanel_Subsystem;
    public static DriveBase_Subsystem driveBase_Subsystem;
    public static Intake_Subsystem intake_Subsystem;
    public static Shooter_Subsystem shooter_Subsystem;
    public static Storage_Subsystem storage_Subsystem;

    // After these, put object declarations (for cameras, ultrasonic, ...)

    // Motor Controllers:

    // Drive Base
    public static WPI_TalonSRX m_leftDriveTalon;
    public static WPI_TalonSRX m_rightDriveTalon;
    public static WPI_VictorSPX m_frontLeftVic;
    public static WPI_VictorSPX m_backLeftVic;
    public static WPI_VictorSPX m_frontRightVic;
    public static WPI_VictorSPX m_backRightVic;

    public static SpeedControllerGroup m_leftDrive;
    public static SpeedControllerGroup m_rightDrive;

    public static DifferentialDrive BMoneysDriveBase;

    // Shooter
    public static WPI_TalonSRX shooterTalon;

    // Control Panel
    public static WPI_TalonSRX controlPanelTalon;

    // Intake
    public static WPI_TalonSRX intakeTalon;

    // Storage
    public static WPI_VictorSPX lstorageVictor;
    public static WPI_VictorSPX rstorageVictor;

    // Solenoids:
    public static Compressor compressor;

        //Intake
    public static DoubleSolenoid leftPneumaticPiston;
    public static DoubleSolenoid rightPneumaticPiston;

        //Shooter
    public static DoubleSolenoid shootPneumaticPistonOne;
    public static DoubleSolenoid shootPneumaticPistonTwo;
    public static DoubleSolenoid shootPneumaticPistonThree;

    // Climb

    // public static DoubleSolenoid climbPiston;

    // Switches

    // Limit Switches
    // public static DigitalInput limitSwitch;

    // Sensors
    public static ColorSensorV3 colorSensor;
    public static I2C.Port i2cPort = I2C.Port.kOnboard;

    //Joystick buttons
    public static JoystickButton AButton; // A
    public static JoystickButton BButton; // B
    public static JoystickButton XButton; // ...
    public static JoystickButton YButton;
    public static JoystickButton SelectButton;
    public static JoystickButton StartButton;
    public static JoystickButton LBButton; // Left bumper button
    public static JoystickButton RBButton; // ...

    // Triggers
    public static Trigger rTrigger;
    public static Trigger lTrigger;

    // DPad Buttons (names)
    public static POVButton uDPadButton; // Up DPad
    public static POVButton dDPadButton; // Down DPad
    public static POVButton lDPadButton; // Left DPad
    public static POVButton rDPadButton; // Right DPad
    public static POVButton ulDPadButton; // Up-Left DPad
    public static POVButton urDPadButton; // Up-Right DPad
    public static POVButton dlDPadButton; // Down-Left DPad
    public static POVButton drDPadButton; // Down-Right DPad
    public static POVButton nDPadButton; // no press on DPad

    // create Joystick variable name
    public static Joystick XBoxController; // Static means that the method/class the variable or method belongs too
                                           // doesn't need to be created

    // create SmartDashboard name
    public static SmartDashboard smartDashboard;
    public static ShuffleboardTab diagnosticTab;
    public static ShuffleboardTab liveWindowTab;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        // Similar to RobotMap, now we are going to create all the subsystem objects
        // (for commands)
        InitMap();

        // Configure the button bindings
        controlPanel_Subsystem = new ControlPanel_Subsystem();
        shooter_Subsystem = new Shooter_Subsystem();
        climb_Subsystem = new Climb_Subsystem();
        intake_Subsystem = new Intake_Subsystem();
        storage_Subsystem = new Storage_Subsystem();

        configureButtonBindings();

        driveBase_Subsystem = new DriveBase_Subsystem(); //needs to go after since it uses an extended OI, which requires 
        //button bindings to be run for its buttons to be mapped first...

        // Set creation of other objects (like cameras)

        // For cameras, set defaults here (like resolution, framerate, ...)

    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     * 
     * This is the exact same as OI from previous years.
     */
    private void configureButtonBindings() {

        XBoxController = new Joystick(Constants.JoystickPort);

        // Test this, may be good for using axes
        
        BooleanSupplier booleanSupply = () -> true;
        rTrigger = new Trigger(booleanSupply);
        rTrigger.whileActiveContinuous(new Shoot_Command()); //NOTE: this version of whileActiveContinuous overrides any and all drive base control. May need to change.
        rTrigger.cancelWhenActive(new ArcadeDrive());

        rTrigger.whenInactive(new ArcadeDrive());

        // Sets B Button to do Control Panel Command
        BButton = new JoystickButton(XBoxController, Constants.BButtonPort);
        BButton.whenHeld(new ControlPanel_Command());

        XButton = new JoystickButton(XBoxController, Constants.XButtonPort);
        XButton.toggleWhenPressed(new Intake_Command());

    }

    public void InitMap() {

        // Shuffle Board initialization:
        diagnosticTab = Shuffleboard.getTab("Diagnostics");
        liveWindowTab = Shuffleboard.getTab("Live Window");
        SmartDashboard.putNumber("Ball Count", Constants.startingBallCount);

        // Drive Base Moter Initialization:
        m_leftDriveTalon = new WPI_TalonSRX(Constants.leftDriveTalonCAN); // other motor controllers will follow this controller
        m_leftDriveTalon.set(ControlMode.Current, 0);
        m_leftDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //may need to change configs on MAG Encoder

        m_frontLeftVic = new WPI_VictorSPX(Constants.fLeftDriveVictorCAN);
        m_frontLeftVic.set(ControlMode.Follower, Constants.leftDriveTalonCAN);

        m_backLeftVic = new WPI_VictorSPX(Constants.bLeftDriveVictorCAN);
        m_backLeftVic.set(ControlMode.Follower, Constants.leftDriveTalonCAN);

        m_rightDriveTalon = new WPI_TalonSRX(Constants.rightDriveTalonCAN); // other motor controllers will follow this controller
        m_rightDriveTalon.set(ControlMode.Current, 0);
        m_rightDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //may need to change configs on MAG Encoder

        m_frontRightVic = new WPI_VictorSPX(Constants.fRightDriveVictorCAN);
        m_frontRightVic.set(ControlMode.Follower, Constants.rightDriveTalonCAN);

        m_backRightVic = new WPI_VictorSPX(Constants.bRightDriveVictorCAN);
        m_backRightVic.set(ControlMode.Follower, Constants.rightDriveTalonCAN);

        m_leftDrive = new SpeedControllerGroup(m_leftDriveTalon, m_frontLeftVic, m_backLeftVic); // Ports in order:
                                                                                                 // 1, 2, 3
        m_rightDrive = new SpeedControllerGroup(m_rightDriveTalon, m_frontRightVic, m_backRightVic); // 4, 5, 6

        BMoneysDriveBase = new DifferentialDrive(m_leftDrive, m_rightDrive);

        // Init ControlPanel Motors
        controlPanelTalon = new WPI_TalonSRX(Constants.controlPanelCAN);
        controlPanelTalon.set(ControlMode.Velocity, 0);
        controlPanelTalon.setInverted(true);
        controlPanelTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //may need to change configs on MAG Encoder


        // Init Intake Motors
        intakeTalon = new WPI_TalonSRX(Constants.intakeCAN);
        intakeTalon.set(ControlMode.PercentOutput, 0);

        // Init Shooter Motors
        shooterTalon = new WPI_TalonSRX(Constants.shooterCAN);
        shooterTalon.set(ControlMode.Velocity, 0);
        shooterTalon.setInverted(true);
        shooterTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //may need to change configs on MAG Encoder

        //Storage Motors
        lstorageVictor = new WPI_VictorSPX(Constants.lstorageCAN);
        lstorageVictor.set(ControlMode.Current, 0);
        lstorageVictor.setInverted(true);
        //may need to invert these motors

        rstorageVictor = new WPI_VictorSPX(Constants.rstorageCAN);
        rstorageVictor.set(ControlMode.Current, 0);

        // Sensor Init
        colorSensor = new ColorSensorV3(i2cPort);

        //Solenoid Init 

        //Intake
        leftPneumaticPiston = new DoubleSolenoid(Constants.PCMCAN, Constants.leftPneuForwardChannel, Constants.leftPneuBackChannel);
        rightPneumaticPiston = new DoubleSolenoid(Constants.PCMCAN, Constants.rightPneuForwardChannel, Constants.rightPneuBackChannel);
        compressor = new Compressor(Constants.PCMCAN);
        RobotContainer.compressor.setClosedLoopControl(true);
        
        //Shooter
        shootPneumaticPistonOne = new DoubleSolenoid(Constants.PCMCAN, Constants.shootPneumaticP1ForwardChannel, Constants.shootPneumaticP1BackChannel);
        shootPneumaticPistonTwo = new DoubleSolenoid(Constants.PCMCAN, Constants.shootPneumaticP2ForwardChannel, Constants.shootPneumaticP2BackChannel);
        shootPneumaticPistonThree = new DoubleSolenoid(Constants.PCMCAN, Constants.shootPneumaticP3ForwardChannel, Constants.shootPneumaticP3BackChannel);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    // public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // Command m_autoCommand = ;
    // return m_autoCommand;
    // }

}