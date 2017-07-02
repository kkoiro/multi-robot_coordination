package mypackage;

import java.lang.Thread;
import java.lang.InterruptedException;


public class RobotController implements Runnable {
  RobotRoom robotroom;
  Robot robot;

  public RobotController(RobotRoom robotroom, Robot robot) {
    this.robotroom = robotroom;
    this.robot = robot;
  }

  @Override
  public void run() {
    try {
      while(true) {
        robot.move(robot.getX()+10, robot.getY()+10);
        System.out.println(robot.getId());
        Thread.sleep(1000);
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
