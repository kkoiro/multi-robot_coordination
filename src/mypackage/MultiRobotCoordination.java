package mypackage;

import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Graphics;


public class MultiRobotCoordination {
  public static void main(String args[]) {
    final int ROOM_SIZE = 512;
    final int RADIUS = 200;
    final int ROBOT_COUNT= 8;
    final Robot[] robots;
    final RobotRoom robotroom;

    System.out.println("Hello, world");
    robotroom = new RobotRoom(ROOM_SIZE, RADIUS, ROBOT_COUNT);
  }

  public void paint(Graphics g) {
  }
}


class RobotRoom extends JFrame {
  private int roomSize;
  private int radius;
  private int robotCount;
  private Point[] robotDestinations;

  RobotRoom(int roomSize, int radius, int robotCount) {
    this.roomSize = roomSize;
    this.radius = radius;
    this.robotCount = robotCount;
    this.robotDestinations = new Point[robotCount];
    this.setRobotDestinations(roomSize, radius, robotCount);
    this.setTitle("Multi-Robot coordination");
    this.setSize(roomSize, roomSize);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void setRobotDestinations(int roomSize, int radius, int robotCount) {
    int center = roomSize / 2;
    int i;
    for(i = 0; i < robotCount; i++) {
      int x = (int)(Math.cos(i * (2 * Math.PI / robotCount)) * radius) + center;
      int y = (int)(Math.sin(i * (2 * Math.PI / robotCount)) * radius) + center;
      this.robotDestinations[i] = new Point(x, y);
    }
  }

}


class Robot {
  private final int id;
  private Point location;
  private boolean state;

  Robot(int id, int x, int y) {
    this.id = id;
    location = new Point(x, y);
    state = true;
  }

  int getId() {
    return id;
  }

  Point getLocation() {
    return location;
  }

  boolean getState() {
    return state;
  }

  void powerOff() {
    state = false;
  }
}
