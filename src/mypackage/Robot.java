package mypackage;

import java.awt.Color;


public class Robot {
  private final int id;
  private int x;
  private int y;
  private Color color;
  private boolean state;

  public Robot(int id, int x, int y, int color) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.color = new Color(color);
    state = true;
  }

  public int getId() {
    return id;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Color getColor() {
    return color;
  }

  public boolean getState() {
    return state;
  }

  public void moveUp() {
    this.y -= 1;
  }

  public void moveDown() {
    this.y += 1;
  }

  public void moveLeft() {
    this.x -= 1;
  }

  public void moveRight() {
    this.x += 1;
  }

  public void powerOff() {
    state = false;
  }
}
