package mypackage;

import java.awt.Point;


public class Robot {
  private final int id;
  private Point location;
  private boolean state;

  public Robot(int id, int x, int y) {
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
