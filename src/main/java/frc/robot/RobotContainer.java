package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TeleOpDriveCommand;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.TankDriveSubsystem;

public class RobotContainer {
    // private SendableChooser<Command> autonChooser = new SendableChooser<Command>();
    private TankDriveSubsystem driveSubsystem = new TankDriveSubsystem();
    private FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
    private CommandXboxController controller;
    private TeleOpDriveCommand driveCommand;
    
    private final Trigger shootButton = controller.leftBumper();
    public RobotContainer() {
        configureTankDrive();
        configureShooter();
    }

    public void configureTankDrive() {
        driveCommand = new TeleOpDriveCommand(driveSubsystem, controller);
        driveSubsystem.setDefaultCommand(driveCommand);

        Shuffleboard.getTab("Driver Controls").add("Drive Subsystem", driveSubsystem);
    }

    public void configureShooter() {
        shootButton.toggleOnTrue(new ShootCommand(flywheelSubsystem, 1));
        shootButton.toggleOnFalse(new ShootCommand(flywheelSubsystem, 0));

        Shuffleboard.getTab("Driver Controls").add("Flywheel Subsystem", flywheelSubsystem);
    }



    
    // public Command getAutonomousCommand() {
    //     return autonChooser.getSelected();
    // }
    public Command getAutonomousCommand() {
        return null;
    }

    public void teleopInit() {

    }

    // public void teleopInit() {
    //     Command auton = autonChooser.getSelected();
    //     if (auton != null){
    //         auton.cancel();
    //     }

    // }

}