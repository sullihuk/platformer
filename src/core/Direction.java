package core;

public enum Direction {
  L(0),
  R(1),
  U(2),
  D(3);
  // N(4),
  // NE(5),
  // E(6),
  // SE(7);

  private int animationRow;

  Direction(int animationRow) {
    this.animationRow = animationRow;
  }

  public static Direction fromMovement(Movement movement) {
    double x = movement.getVector().getX();
    double y = movement.getVector().getY();
    if (x > 0 && y == 0)
      return L;
    if (x < 0 && y == 0)
      return R;
    if (x == 0 && y < 0)
      return D;
    if (x == 0 && y > 0)
      return U;
    /*
     * if (x < 0 && y > 0)
     * return SW;
     * if (x < 0 && y < 0)
     * return NW;
     * if (x > 0 && y < 0)
     * return NE;
     * if (x > 0 && y > 0)
     * return SE;
     */

    return R;
  }

  public int getAnimationRow() {
    return animationRow;
  }

}
