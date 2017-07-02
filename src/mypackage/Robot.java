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

  public int getId() {
    return id;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
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
