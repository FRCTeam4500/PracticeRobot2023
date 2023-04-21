package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.TankDriveSubsystem;

public class TeleOpDriveCommand extends CommandBase{
    private TankDriveSubsystem m_tankDrive;
    private CommandXboxController m_controller;
    private DriveMode mode;
    public TeleOpDriveCommand(TankDriveSubsystem tankDrive, CommandXboxController controller) {
        m_tankDrive = tankDrive;
        m_controller = controller;
        mode = DriveMode.Normal;
    }

    public void execute() {
        setCase();
        switch (mode) {
            case TurnOnly:
                m_tankDrive.setLeftOutput(m_controller.getRightX());
                m_tankDrive.setRightOutput(-m_controller.getRightX());
                break;
            default:
                m_tankDrive.setLeftOutput(-m_controller.getLeftY());
                m_tankDrive.setRightOutput(-m_controller.getRightY());
        }
    }

    public void setCase() {
        if (Math.abs(m_controller.getLeftX()) > 0) {
            mode = DriveMode.TurnOnly;
        } else {
            mode = DriveMode.Normal;
        }
    }

    public enum DriveMode {
        Normal,
        TurnOnly
    }

}
