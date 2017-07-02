package mypackage;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.InterruptedException;
import java.lang.Thread;
import java.util.Random;


public class RobotRoom extends JFrame implements Runnable {
  public final int roomSize;
  public final int radius;
  public final int robotCount;
  private RobotDestination[] robotDestinations;
  private Robot[] robots;

  public RobotRoom(int roomSize, int radius, int robotCount) {
    this.roomSize = roomSize;
    this.radius = radius;
    this.robotCount = robotCount;
    robotDestinations = new RobotDestination[robotCount];
    setRobotDestinations(roomSize, radius, robotCount);
    robots = new Robot[robotCount];
    setRobots(roomSize, robotCount);
    setTitle("Multi-Robot coordination");
    setSize(roomSize, roomSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void setRobotDestinations(int roomSize, int radius, int robotCount) {
    int center = roomSize / 2;
    int i;
    for(i = 0; i < robotCount; i++) {
      int x = (int)((Math.cos(i * (2 * Math.PI / robotCount)) * radius) + center);
      int y = (int)((Math.sin(i * (2 * Math.PI / robotCount)) * radius) + center);
      robotDestinations[i] = new RobotDestination(x, y);
    }
  }

  private void setRobots(int roomSize, int robotCount) {
    Random random = new Random();
    int i;
    for(i = 0; i < robotCount; i++) {
      robots[i] = new Robot(i, random.nextInt(roomSize), random.nextInt(roomSize), random.nextInt((int)Math.pow(2, 24)));
    }
  }

  public RobotDestination getRobotDestination(int index) {
    return robotDestinations[index];
  }

  @Override
  public void paint(Graphics g) {
    g.clearRect(0, 0, roomSize, roomSize);
    int i;
    for(i = 0; i < robotCount; i++) {
      g.setColor(robots[i].getColor());
      g.fillOval(robots[i].getX(), robots[i].getY(), 10, 10);
    }
  }

  @Override
  public void run() {
    int i;
    for(i = 0; i < robotCount; i++) {
      Thread thread = new Thread(new RobotController(this, robots[i]));
      thread.start();
    }
    try {
      while(true) {
        repaint();
        Thread.sleep(MultiRobotCoordination.SLEEP_TIME);
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
