package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelSubsystem;

public class ShootCommand extends CommandBase{
    private FlywheelSubsystem flywheel;
    private double targetOutput;
    public ShootCommand(FlywheelSubsystem flywheelSubsystem, double output) {
        flywheel = flywheelSubsystem;
        targetOutput = output;
    }

    public void initialize() {
        flywheel.setShooterSpeed(targetOutput);
    }

    public boolean isFinished() {
        return true;
    }
}
