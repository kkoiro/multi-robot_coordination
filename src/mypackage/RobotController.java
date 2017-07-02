package mypackage;

import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Random;


public class RobotController implements Runnable {
  private RobotRoom robotRoom;
  private Robot robot;

  public RobotController(RobotRoom robotRoom, Robot robot) {
    this.robotRoom = robotRoom;
    this.robot = robot;
  }

  private int getNearestRobotDestinationIndex(int x, int y) {
    int nearestRobotDestinationIndex = 0;
    double shotestDistance = Math.pow(robotRoom.roomSize, 2);
    double distance;
    int i;
    for(i = 0; i < robotRoom.robotCount; i++){
      distance = Math.pow(x - robotRoom.getRobotDestination(i).getX(), 2) + Math.pow(y - robotRoom.getRobotDestination(i).getY(), 2);
      if(distance < shotestDistance) {
        shotestDistance = distance;
        nearestRobotDestinationIndex = i;
      }
    }
    return nearestRobotDestinationIndex;
  }

  private int roundRobin(int prevIdx) {
    return (prevIdx + 1) % robotRoom.robotCount;
  }

  private int random(int prevIdx) {
    Random random = new Random();
    int nextIdx = prevIdx;
    while(nextIdx != prevIdx) {
      nextIdx = random.nextInt(robotRoom.robotCount);
    }
    return nextIdx;
  }

  @Override
  public void run() {
    System.out.println("Robot[" + robot.getId() + "] is powered on!!!");
    boolean flagX = false;
    boolean flagY = false;
    int robotDestinationIndex = getNearestRobotDestinationIndex(robot.getX(), robot.getY());
    int robotDestinationX = robotRoom.getRobotDestination(robotDestinationIndex).getX();
    int robotDestinationY = robotRoom.getRobotDestination(robotDestinationIndex).getY();
    try {
      while(robot.getState()) {
        if(!flagX) {
          if(robot.getX() - robotDestinationX > 0) {
            robot.moveLeft();
          } else if(robot.getX() - robotDestinationX < 0) {
            robot.moveRight();
          } else {
            flagX = true;
          }
        }
        if(!flagY) {
          if(robot.getY() - robotDestinationY > 0) {
            robot.moveUp();
          } else if(robot.getY() - robotDestinationY < 0) {
            robot.moveDown();
          } else {
            flagY = true;
          }
        }
        if(flagX && flagY) {
          boolean result;
          result = robotRoom.getRobotDestination(robotDestinationIndex).lockDestination();
          if(result){
            robot.powerOff();
          } else {
            flagX = false;
            flagY = false;
            robotDestinationIndex = roundRobin(robotDestinationIndex);
            robotDestinationX = robotRoom.getRobotDestination(robotDestinationIndex).getX();
            robotDestinationY = robotRoom.getRobotDestination(robotDestinationIndex).getY();
          }
        }
        Thread.sleep(MultiRobotCoordination.SLEEP_TIME);
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Robot[" + robot.getId() + "]  is powered off ...zzz");
  }
}
