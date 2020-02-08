package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Shooter_Subsystem extends SubsystemBase {
    //Variable declarations go here...
    WPI_TalonSRX shooterTalon;
    
    public Shooter_Subsystem() {
        //Variable assignment goes here...
        shooterTalon = RobotContainer.shooterTalon;
    }

    @Override
    public void periodic() {
        
    }

    public void setVelo(double angle) {
        if (checkReadyShoot()) {
            shooterTalon.set(veloCalc(angle)); //RobotContainer.XBoxController.getRawAxis(Constants.RTAxisPort));
        }
    }

    public double veloCalc(double angle) {
        double finalVelo = 0.0;
        double distAway = findDistance();

        //used to debug distance value
        System.out.println("Distance from target is : " + distAway);
        SmartDashboard.putNumber("Distance from Target", distAway);

        //put calculations with everything here...

        return finalVelo;
    }

    public double findDistance() { //finds distance away from target (tower) in inches...
        //May need to move onto Limelight
        return (Constants.towerHeight / Math.atan(Robot.targety));
    }
    
    public boolean checkReadyShoot() {
        return true; //needs changes obvs
    }
}