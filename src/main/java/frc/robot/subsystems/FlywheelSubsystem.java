package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.component.hardware.TalonSRXComponent;
import frc.robot.utility.ExtendedMath;

public class FlywheelSubsystem {
    private TalonSRXComponent flywheelMotor;
    public FlywheelSubsystem() {
        flywheelMotor = new TalonSRXComponent(FlywheelConstants.FLYWHEEL_MOTOR_ID);
    }

    public void setShooterSpeed(double targetOutput) {
        double output = ExtendedMath.clamp(-1, 1, targetOutput);
        flywheelMotor.setOutput(output);
    }

    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Current Flywheel Speed: ", () -> flywheelMotor.getOutput(), null);
    }
}
