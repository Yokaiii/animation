package cs3500.animator.commands;

import cs3500.animator.drawables.ADrawable;

public class MoveCommand extends ACommand {

  private final double xOrigin;
  private final double yOrigin;
  private final double xDestination;
  private final double yDestination;

  /**
   * Constructor for a MoveCommand.
   *
   * @param s desired start time for the change
   * @param e desired end time for the change
   * @param toX desired x position to move to
   * @param toY desired y position to move to
   */
  public MoveCommand(ADrawable t, int s, int e, double fromX, double fromY, double toX, double toY) {
    super(t, s, e);
    this.xOrigin = fromX;
    this.yOrigin = fromY;
    this.xDestination = toX;
    this.yDestination = toY;
  }

  public void execute() {
    target.move(this.xDestination, this.yDestination);
  }

  /**
   * Returns a string representation of this command.
   *
   * @return this MoveCommand as a string following guidelines
   */
  public String toString() {
    return "Shape " + this.target.getName() + " moves from (" + this.target.getX() + ","
            + this.target.getY() + ") to (" + this.xDestination + "," + this.yDestination
            + ") from t = " + this.startTime + " to t = " + this.endTime;
  }


  public void calculate(long current) {
    target.move(calculateValue(current, xOrigin, xDestination),
            calculateValue(current, yOrigin, yDestination));
  }
}
