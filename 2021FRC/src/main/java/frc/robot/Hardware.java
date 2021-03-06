/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Hardware {

    // drive motor
    public WPI_TalonFX m_leftFront;
    public WPI_TalonFX m_leftFollower;
    public WPI_TalonFX m_rghtFront;
    public WPI_TalonFX m_rghtFollower;

    public DifferentialDrive m_diffDrive;

    public Hardware(){

        // drive
        m_leftFront = new WPI_TalonFX(1);
        m_leftFollower = new WPI_TalonFX(2);
        m_rghtFront = new WPI_TalonFX(3);
        m_rghtFollower = new WPI_TalonFX(4);
                
        m_diffDrive = new DifferentialDrive(m_leftFront, m_rghtFront);

        m_diffDrive.setMaxOutput(0.5);
      
        /* factory default values */
        m_rghtFront.configFactoryDefault();
        m_rghtFollower.configFactoryDefault();
        m_leftFront.configFactoryDefault();
        m_leftFollower.configFactoryDefault();

        /* set up followers */
        m_rghtFollower.follow(m_rghtFront);
        m_leftFollower.follow(m_leftFront);

        /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
        m_rghtFront.setInverted(TalonFXInvertType.Clockwise); // !< Update this
        m_leftFront.setInverted(TalonFXInvertType.CounterClockwise); // !< Update this

        /*
         * set the invert of the followers to match their respective master controllers
         */
        m_rghtFollower.setInverted(InvertType.FollowMaster);
        m_leftFollower.setInverted(InvertType.FollowMaster);
		
        m_diffDrive.setRightSideInverted(false);

    }

    
}
