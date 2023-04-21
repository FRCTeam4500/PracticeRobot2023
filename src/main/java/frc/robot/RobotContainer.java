package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.TeleOpDriveCommand;
import frc.robot.subsystems.TankDriveSubsystem;

public class RobotContainer {
    private SendableChooser<Command> autonChooser = new SendableChooser<Command>();
    private TankDriveSubsystem driveSubsystem;
    private CommandXboxController controller;
    private TeleOpDriveCommand driveCommand;
    
    public RobotContainer() {
    }

    public void configureTankDrive() {
        driveCommand = new TeleOpDriveCommand(driveSubsystem, controller);
        driveSubsystem.setDefaultCommand(driveCommand);

        Shuffleboard.getTab("Driver Controls").add("Drive Subsystem", driveSubsystem);
    }
    
    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }

    public void teleopInit() {
        Command auton = autonChooser.getSelected();
        if (auton != null){
            auton.cancel();
        }

    }

}