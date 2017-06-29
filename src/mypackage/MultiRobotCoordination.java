package mypackage;

import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;


public class MultiRobotCoordination {
  final static int ROOM_SIZE = 512;
  final static int RADIUS = 200;
  final static int ROBOT_COUNT= 8;

  public static void main(String args[]) {
    final Robot[] robots;
    final RobotRoom robotroom;
    System.out.println("Hello, world");
    robotroom = new RobotRoom(ROOM_SIZE, RADIUS, ROBOT_COUNT);
  }
}
