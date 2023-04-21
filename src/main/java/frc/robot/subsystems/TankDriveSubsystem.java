package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankDriveConstants;
import frc.robot.component.hardware.TalonSRXComponent;

public class TankDriveSubsystem extends SubsystemBase{
    private TalonSRXComponent leftDriveMotor;
    private TalonSRXComponent rightDriveMotor;
    private double targetLeftOutput;
    private double targetRightOutput;
        public TankDriveSubsystem() {
            leftDriveMotor = new TalonSRXComponent(TankDriveConstants.LEFT_DRIVE_MOTOR_ID);
            rightDriveMotor = new TalonSRXComponent(TankDriveConstants.RIGHT_DRIVE_MOTOR_ID);
            targetLeftOutput = 0;
            targetRightOutput = 0;
        }

        public void setLeftOutput(double targetOutput) {
            targetLeftOutput = targetOutput;
            leftDriveMotor.setOutput(targetOutput);
        }

        public double getLeftOutput() {
            return leftDriveMotor.getOutput();
        }

        public double getTargetLeftOutput() {
            return targetLeftOutput;
        }

        public void setRightOutput(double targetOutput) {
            targetRightOutput = targetOutput;
            rightDriveMotor.setOutput(targetOutput);
        }

        public double getRightOutput() {
            return rightDriveMotor.getOutput();
        }

        public double getTargetRightOutput() {
            return targetRightOutput;
        }

        public void initSendable(SendableBuilder builder) {
            builder.addDoubleProperty("Current Left Drive Motor Output: ", this::getLeftOutput, null);
            builder.addDoubleProperty("Target Left Drive Motor Output: ", this::getTargetLeftOutput, null);
            builder.addDoubleProperty("Current Right Drive Motor Output: ", this::getRightOutput, null);
            builder.addDoubleProperty("Target Right Drive Motor Output: ", this::getTargetRightOutput, null);
        }
}
