package mypackage;

import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Random;


public class MultiRobotCoordination {
  final static int ROOM_SIZE = 512;
  final static int RADIUS = 200;
  final static int ROBOT_COUNT= 8;
  static RobotRoom robotroom;

  public static void main(String args[]) {
    System.out.println("Start simulation");
    robotroom = new RobotRoom(ROOM_SIZE, RADIUS, ROBOT_COUNT);
    Thread thread = new Thread(robotroom);
    thread.start();
  }
}
