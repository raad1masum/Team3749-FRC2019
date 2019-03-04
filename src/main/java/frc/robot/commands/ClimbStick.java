/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClimbStick extends Command {
  public ClimbStick() {
    requires(Robot.getClimb());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double input = Robot.getOI().getClimbY();
    // if enabled
    if (Robot.getMap().getSys("climb") > 0)
    {
      if (Robot.getClimb().atEnd() && input > 0)
        Robot.getClimb().rawMove(0);
      else
        Robot.getClimb().rawMove(input);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
