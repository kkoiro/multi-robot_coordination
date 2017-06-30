package mypackage;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.InterruptedException;
import java.lang.Thread;
import java.util.Random;


public class RobotRoom extends JFrame implements Runnable {
  private int roomSize;
  private int radius;
  private int robotCount;
  private RobotDestination[] robotDestinations;
  private Robot[] robots;

  public RobotRoom(int roomSize, int radius, int robotCount) {
    this.roomSize = roomSize;
    this.radius = radius;
    this.robotCount = robotCount;
    robotDestinations = new RobotDestination[robotCount];
    calculateRobotDestinations(roomSize, radius, robotCount);
    robots = new Robot[robotCount];
    createRobots(roomSize, robotCount);
    setTitle("Multi-Robot coordination");
    setSize(roomSize, roomSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void calculateRobotDestinations(int roomSize, int radius, int robotCount) {
    int center = roomSize / 2;
    int i;
    for(i = 0; i < robotCount; i++) {
      int x = (int)((Math.cos(i * (2 * Math.PI / robotCount)) * radius) + center);
      int y = (int)((Math.sin(i * (2 * Math.PI / robotCount)) * radius) + center);
      robotDestinations[i] = new RobotDestination(x, y);
    }
  }

  private void createRobots(int roomSize, int robotCount) {
    Random random = new Random();
    int i;
    for(i = 0; i < robotCount; i++) {
      robots[i] = new Robot(i, random.nextInt(roomSize), random.nextInt(roomSize));
    }
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.clearRect(0, 0, roomSize, roomSize);
    int i;
    for(i = 0; i < robotCount; i++) {
      g.fillOval(robots[i].getX(), robots[i].getY(), 5, 5);
    }
  }

  @Override
  public void run() {
    try {
      while(true) {
        repaint();
        Thread.sleep(1000);
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
