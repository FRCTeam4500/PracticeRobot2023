package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.TankDriveSubsystem;

public class TeleOpDriveCommand extends CommandBase{
    private TankDriveSubsystem m_tankDrive;
    private CommandXboxController m_controller;
    public TeleOpDriveCommand(TankDriveSubsystem tankDrive, CommandXboxController controller) {
        m_tankDrive = tankDrive;
        m_controller = controller;
    }

    public void execute() {
        m_tankDrive.setLeftOutput(-m_controller.getLeftY());
        m_tankDrive.setRightOutput(-m_controller.getRightY());
    }


}
