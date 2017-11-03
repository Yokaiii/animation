package cs3500.animator.model;

import cs3500.animator.commands.ACommand;
import cs3500.animator.drawables.ADrawable;

/**
 * Representation of an animation. Contains one or more drawable objects and a list of commands to
 * execute
 */

public interface IAnimation {

  /**
   * Returns a string representation of this animation, ie a list of the drawable objects and a list
   * of all the different changes to be applied to them.
   *
   * @return A read back of the animation
   */
  String toString();

  /**
   * Add a command to this animation's list of commands to execute.
   *
   * @param command the command to add
   */
  void addCommand(ACommand command);

  /**
   * Add a drawable to this animation's list of drawables.
   *
   * @param drawable the drawable to add
   */
  void addDrawable(ADrawable drawable);

  ADrawable runCommand(ADrawable target, ACommand cmd);

  /**
   * Updates this model based off a given current time and a speed
   * @param currentTime
   */
  void updateOffTime(long currentTime, int speed);
}
