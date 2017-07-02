package mypackage;

import java.lang.Thread;
import java.lang.InterruptedException;


public class MultiRobotCoordination {
  public final static int SLEEP_TIME = 10;
  final static int ROOM_SIZE = 512;
  final static int RADIUS = 200;
  final static int ROBOT_COUNT= 8;
  static RobotRoom robotRoom;

  public static void main(String args[]) {
    System.out.println("Start simulation");
    robotRoom = new RobotRoom(ROOM_SIZE, RADIUS, ROBOT_COUNT);
    Thread thread = new Thread(robotRoom);
    thread.start();
  }
}
