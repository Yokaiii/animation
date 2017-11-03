package cs3500.animator.commands;

import cs3500.animator.drawables.ADrawable;

/**
 * Representation of a command describing some change to a drawable object.
 */
public abstract class ACommand implements Comparable<ACommand> {

  protected ADrawable target;
  protected int startTime;
  protected int endTime;



  /**
   * Constructor for an ACommand.
   *
   * @param t the ADrawable to apply the command to
   * @param s desired start time for the change
   * @param e desired end time for the change
   */
  public ACommand(ADrawable t, int s, int e) {
    if (t == null) {
      throw new IllegalArgumentException("Cannot create a command for a null drawable object");
    if (s < 0) {
      throw new IllegalArgumentException("Cannot start at a negative time");
    }
    if (e <= s) {
      throw new IllegalArgumentException("Cannot have an end time before the start");
    }
    this.target = t;
    this.startTime = s;
    this.endTime = e;
  }

  /**
   * Executes this command on the target.
   */
  public abstract void execute();

  /**
   * Returns < 0 if the given command follows this one, 0 if they occur simultaneously, and > 0 if
   * the given command precedes this one. Defined to allow sorting of commmands in an Animation.
   *
   * @param other the command to compareTo this
   * @return a negative number, 0, or positive number based on the comparison
   */
  public int compareTo(ACommand other) {
    return (this.startTime - other.startTime);
  }

  /**
   * Returns whether the given command conflicts time wise with this command.
   *
   * @param other the command to check against this
   * @return whether the command given conflicts with this
   */
  public boolean conflict(ACommand other) {
    return other.startTime >= this.startTime
            && other.startTime <= this.endTime;
  }

  /**
   * Return whether this command falls into a given timeframe.
   *
   * @param beginning beginning of the time frame
   * @param end       end of the time frame
   * @return if this command's time frame falls within the range beginning-end
   */
  public boolean fitInTimeFrame(int beginning, int end) {
    return beginning <= this.startTime
            && end >= this.endTime;
  }

  /**
   * Given the current time calculate new values and run the command
   * @param time
   */
  public abstract void calculate(long time);

  protected float calculateValue(long currentTime, float x1, float x2) {
    return  x1 * ((this.endTime - currentTime) / (this.endTime - this.startTime))
            + x2 * ((currentTime - this.startTime) / (this.endTime - this.startTime));
  }
}

