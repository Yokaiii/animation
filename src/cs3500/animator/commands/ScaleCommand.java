package cs3500.animator.commands;

import cs3500.animator.drawables.ADrawable;

public class ScaleCommand extends ACommand {

  private final double xOriginal;
  private final double yOriginal;
  private final double xDesired;
  private final double yDesired;

  /**
   * Constructor for a ScaleCommand.
   *
   * @param s desired start time for the change
   * @param e desired end time for the change
   * @param toX desired width to scale to
   * @param toY desired height to scale to
   */
  public ScaleCommand(ADrawable t, double fromX, double fromY,
                      double toX, double toY, int s, int e) {
    super(t, s, e);
    this.xOriginal = fromX;
    this.yOriginal = fromY;
    this.xDesired = toX;
    this.yDesired = toY;
  }

  /**
   * Returns a string representation of this ScaleCommand.
   *
   * @return this ScaleCommand as a string
   */
  public String toString() {
    return "Shape " + this.target.getName() + " scales from Width: " + this.target.getWidth()
            + ", Height: " + this.target.getHeight() + " to Width: " + this.xDesired
            + ", Height: " + this.yDesired + " from t = " + this.startTime + " to t = "
            + this.endTime;
  }

  @Override
  public void execute() {
    target.scale(this.xDesired, this.yDesired);
  }

  private double calculateX (long current) {
    return this.xOriginal * ((this.endTime - current) / (this.endTime - this.startTime))
            + this.xDesired * ((current - this.startTime) / (this.endTime - this.startTime));
  }

  private double calculateY(long current) {
    return this.yOriginal * ((this.endTime - current) / (this.endTime - this.startTime))
            + this.yDesired * ((current - this.startTime) / (this.endTime - this.startTime));
  }

  public void calculate(long current) {
    target.scale(calculateValue(current, xOriginal, xDesired),
            calculateValue(current, yOriginal, yDesired));
  }
}
