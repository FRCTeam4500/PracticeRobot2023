package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.component.hardware.TalonSRXComponent;
import frc.robot.utility.ExtendedMath;

public class FlywheelSubsystem {
    private TalonSRXComponent flywheelMotor1;
    private TalonSRXComponent flywheelMotor2;
    public FlywheelSubsystem() {
        flywheelMotor1 = new TalonSRXComponent(FlywheelConstants.FLYWHEEL_1_MOTOR_ID);
        flywheelMotor2 = new TalonSRXComponent(FlywheelConstants.FLYWHEEL_2_MOTOR_ID);
    }

    public void setShooterSpeed(double targetOutput) {
        double output = ExtendedMath.clamp(-1, 1, targetOutput);
        flywheelMotor1.setOutput(output);
        flywheelMotor2.setOutput(-output);
    }

    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Current Flywheel Speed: ", () -> Math.abs(flywheelMotor1.getOutput()), null);
    }
}
