package cs3500.animator.drawables;

import java.awt.Color;
import java.util.Objects;

/**
 * Representation of a rectangle shape.
 */
public class Rectangle extends ADrawable {
  public static final DrawableType TYPE = DrawableType.RECTANGLE;
  private double width;
  private double height;

  /**
   * Constructor for a rectangle.
   *
   * @param w desired width
   * @param h desired height
   * @param x desired x position
   * @param y desired y position
   * @param c desired color
   * @param n desired name
   * @param s desired start time
   * @param e desired end time
   */
  public Rectangle(float w, float h, float x, float y, float r, float g, float b, String n, int s, int e) {
    super(x, y, r, g, b, n, s, e);
    this.width = w;
    this.height = h;
  }

  /*
  public void scale(double factor) {
    if (factor > 0) {
      this.width = this.width * factor;
      this.height = this.height * factor;
    }
  }*/

  /**
   * Scales this Rectangle in two directions (x & y).
   *
   * @param xDesired width to scale to
   * @param yDesired height to scale to
   */
  @Override
  public void scale(double xDesired, double yDesired) {
    this.width = xDesired;
    this.height = yDesired;
  }

  /**
   * Returns a string representation of this circle in accordance with the given template: Name: x
   * Type: x. Center: (x, y), xRadius: x, yRadius: x, Color:(R, G, B)
   *
   * @return a string representation of this rectangle
   */
  public String toString() {
    return "Name: " + this.name + "\nType: Rectangle" + "\nCenter: (" + this.xPos + ","
            + this.yPos + "), Width: " + this.width + ", Height: " + this.height + ", Color: ("
            + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue()
            + ")\nAppears at t = " + this.startTime + "\nDisappears at t = " + this.endTime;
  }

  /**
   * Returns whether the given object is equal to this Rectangle. Equality is determined by a same
   * position, name, color, start/end time and size.
   *
   * @param other the object to compare to this Rectangle
   * @return whether the two are equal (same values in the fields)
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Rectangle)) {
      return false;
    }
    Rectangle r = (Rectangle) other;
    return (this.name.equals(r.name))
            && (this.color.equals(r.color))
            && (this.xPos == r.xPos)
            && (this.yPos == r.yPos)
            && (Double.compare(this.width, r.width) == 0)
            && (Double.compare(this.height, r.height) == 0)
            && this.startTime == r.startTime
            && this.endTime == r.endTime;
  }

  public int hashCode() {
    return Objects.hash(this.xPos, this.yPos, this.width,
            this.height, this.color, this.name);
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public IDrawable changeShape(DrawableType type) {
    switch (type) {
      case OVAL:
        return new Oval(this.getWidth() / 2, this.getHeight() / 2, this.xPos,
                this.yPos, this.color, this.name, this.startTime, this.endTime);
      case RECTANGLE:
        return this;
      default:
        throw new IllegalArgumentException("Somehow invalid enum");
    }
  }
}
