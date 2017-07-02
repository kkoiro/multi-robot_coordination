package mypackage;

import java.lang.Thread;
import java.lang.InterruptedException;


public class MultiRobotCoordination {
  public final static int SLEEP_TIME = 10;
  final static int ROOM_SIZE = 512;
  final static int RADIUS = 200;
  static int robotCount;
  static int algorithm;
  static RobotRoom robotRoom;

  public static void main(String args[]) {
    if (args.length != 2) {
      System.out.println("Usage: java mypackage.MultiRobotCoordination [robotCount] [roundroubin=1 | random=2]");
    } else {
      robotCount = Integer.parseInt(args[0]);
      algorithm = Integer.parseInt(args[1]);
      System.out.println("Start simulation");
      robotRoom = new RobotRoom(ROOM_SIZE, RADIUS, robotCount);
      Thread thread = new Thread(robotRoom);
      thread.start();
    }
  }
}
