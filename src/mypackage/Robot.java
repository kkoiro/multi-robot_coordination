package mypackage;


public class Robot {
  private final int id;
  private int x;
  private int y;
  private boolean state;

  public Robot(int id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
    state = true;
  }

  int getId() {
    return id;
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }

  boolean getState() {
    return state;
  }

  void powerOff() {
    state = false;
  }
}
