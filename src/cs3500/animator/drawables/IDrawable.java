package cs3500.animator.drawables;

import java.awt.Color;

/**
 * Representation of a drawable object.
 */

public interface IDrawable {

  /**
   * Changes the color of this object.
   *
   * @param c the color to change the color of this object to
   */
  void changeColor(Color c);

  /**
   * Scales this object to desired size.
   *
   * @param xDesired desired width, x radius, etc
   * @param yDesired desired height, y radius, etc
   */
  void scale(double xDesired, double yDesired);

  /**
   * Moves this drawable object to the given coordinates over a given time duration.
   *
   * @param x The desired x pos
   * @param y The desired y pos
   */
  void move(double x, double y);

  /**
   * Changes this drawable object to a different shape.
   *
   * @param toChangeTo the drawable type to change this to
   * @return a different shape in the same location with the same size
   */
  IDrawable changeShape(DrawableType toChangeTo);
}
