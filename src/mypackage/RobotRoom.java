package mypackage;

import javax.swing.JFrame;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;


public class RobotRoom extends JFrame {
  private int roomSize;
  private int radius;
  private int robotCount;
  private Point[] robotDestinations;

  public RobotRoom(int roomSize, int radius, int robotCount) {
    this.roomSize = roomSize;
    this.radius = radius;
    this.robotCount = robotCount;
    robotDestinations = new Point[robotCount];
    setRobotDestinations(roomSize, radius, robotCount);
    setTitle("Multi-Robot coordination");
    setSize(roomSize, roomSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
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

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.clearRect(0, 0, roomSize, roomSize);
    g.fillOval(roomSize/2, roomSize/2, 5, 5);
  }
}
