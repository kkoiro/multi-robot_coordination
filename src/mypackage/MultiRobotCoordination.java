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
    System.out.println("Hello, world");
    robotroom = new RobotRoom(ROOM_SIZE, RADIUS, ROBOT_COUNT);
    Thread thread = new Thread(robotroom);
    Thread thread2 = new Thread(new MyRunnable());
    thread.start();
    thread2.start();
  }
}


class MyRunnable implements Runnable {
  static int i = 0;

  @Override
  public void run() {
    try {
      while(true) {
        //System.out.println(i);
        Random random = new Random();
        System.out.println(random.nextInt(10));
        i++;
        Thread.sleep(1000);
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
