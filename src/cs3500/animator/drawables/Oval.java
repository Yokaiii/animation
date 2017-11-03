package cs3500.animator.drawables;

import java.awt.Color;
import java.util.Objects;

/**
 * Representation of an oval object (ellipse, circle, etc).
 */
public class Oval extends ADrawable {

  private float xRadius;
  private float yRadius;

  /**
   * Constructor for an oval (which is a circle).
   *
   * @param r radius (since it is a circle only one number)
   * @param x the x position
   * @param y the y position
   * @param c the color
   * @param n the name
   * @param s the starttime
   * @param e the endtime
   */
  public Oval(float radius, float x, float y, float r, float g, float b, String n, int s, int e) {
    super(x, y, r, g, b, n, s, e);
    this.xRadius = radius;
    this.yRadius = radius;
  }


  /**
   * Constructor for an oval (like an ellipse).
   *
   * @param xr the X Radius (1/2 the width of the entire shape)
   * @param yr the Y Radius (1/2 the height of the entire shape)
   * @param x  the x position
   * @param y  the y position
   * @param c  the color
   * @param n  the name
   * @param s  the starttime
   * @param e  the endtime
   */
  public Oval(float xr, float yr, float x, float y, float r, float g, float b, String n, int s, int e) {
    super(x, y, r, g, b, n, s, e);
    this.xRadius = xr;
    this.yRadius = yr;
  }

  /*
  @Override
  public void scale(double factor) {
    if (factor > 0) {
      this.xRadius = factor * this.xRadius;
      this.yRadius = factor * this.yRadius;
    }
  }*/

  /**
   * Scales this Oval in two directions (x & y).
   *
   * @param xDesired x radius to scale to
   * @param yDesired y radius to scale to
   */
  @Override
  public void scale(float xDesired, float yDesired) {
    this.xRadius = xDesired;
    this.yRadius = yDesired;
  }

  /**
   * Returns a string representation of this circle in accordance with the given template: Name: x.
   * Type: x Center: (x, y), xRadius: x, yRadius: x, Color:(R, G, B)
   */
  public String toString() {
    return "Name: " + this.name + "\nType: Oval" + "\nCenter: (" + this.xPos + "," + this.yPos
            + "), X Radius: " + this.xRadius + ", Y Radius: " + this.yRadius + ", Color: ("
            + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue()
            + ")\nAppears at t = " + this.startTime + "\nDisappears at t = " + this.endTime;
  }

  /**
   * Returns whether the given object is equal to this Oval. Equality is determined by a same
   * position, name, color, start/end time and size.
   *
   * @param obj the object to compare to this Oval
   * @return whether the two are equal (same values in the fields)
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Oval)) {
      return false;
    }
    Oval o = (Oval) obj;
    return (this.name.equals(o.name))
            && (this.red.equals(o.red))
            && (this.xPos == o.xPos)
            && (this.yPos == o.yPos)
            && (Double.compare(this.xRadius, o.xRadius) == 0)
            && (Double.compare(this.yRadius, o.yRadius) == 0)
            && this.startTime == o.startTime
            && this.endTime == o.endTime;
  }

  public int hashCode() {
    return Objects.hash(this.xPos, this.yPos, this.xRadius,
            this.yRadius, this.color, this.name);
  }

  @Override
  public double getWidth() {
    return this.xRadius * 2;
  }

  @Override
  public double getHeight() {
    return this.yRadius * 2;
  }

  @Override
  public IDrawable changeShape(DrawableType type) {
    switch (type) {
      case OVAL:
        return this;
      case RECTANGLE:
        return new Rectangle(this.getWidth(), this.getHeight(), this.xPos,
                this.yPos, this.color, this.name, this.startTime, this.endTime);
      default:
        throw new IllegalArgumentException("Somehow invalid enum");
    }
  }
}

