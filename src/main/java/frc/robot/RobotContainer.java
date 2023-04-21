package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    private SendableChooser<Command> autonChooser = new SendableChooser<Command>();
    
    public RobotContainer() {
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