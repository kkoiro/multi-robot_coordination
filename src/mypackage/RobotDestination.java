package mypackage;


public class RobotDestination {
  private int x;
  private int y;
  private boolean status;

  RobotDestination(int x, int y) {
    this.x = x;
    this.y = y;
    status = true;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean getStatus() {
    return status;
  }
}
