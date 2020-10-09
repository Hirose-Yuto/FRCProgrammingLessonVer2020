package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  XboxController controller;
  WPI_TalonSRX driveLeftFrontMotor, driveRightFrontMotor;
  VictorSPX driveLeftBackMotor, driveRightBackMotor;
  DifferentialDrive drive;

  @Override
  public void robotInit() {
    controller = new XboxController(0);

    driveLeftFrontMotor = new WPI_TalonSRX(6);
    driveRightFrontMotor = new WPI_TalonSRX(2);
    driveLeftBackMotor = new VictorSPX(13);
    driveRightBackMotor = new VictorSPX(12);

    driveLeftBackMotor.follow(driveLeftFrontMotor);
    driveRightBackMotor.follow(driveRightFrontMotor);

    drive = new DifferentialDrive(driveLeftFrontMotor, driveRightFrontMotor);
  }

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
  public void teleopInit() {
	}

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(-controller.getY(Hand.kLeft), controller.getX(Hand.kLeft));
  }
  
  @Override
  public void testPeriodic() {
  }

}
