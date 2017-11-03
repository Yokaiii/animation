package cs3500.animator.drawables;

import java.awt.Color;

/**
 * Representation of a drawable object.
 */
public abstract class ADrawable implements IDrawable {
  String name;
  float xPos;
  float yPos;
  float red;
  float green;
  float blue;
  int startTime;
  int endTime;


  /**
   * Constructor for ADrawable.
   *
   * @param x the x position
   * @param y the y position
   * @param c the color
   * @param n the name
   * @param s the start time
   * @param e the end time
   */
  public ADrawable(float x, float y, float red, float green, float blue, String n, int s, int e) {
    if (c == null || n == null) {
      throw new IllegalArgumentException("Cannot take in null values");
    }
    if (e <= s || s < 0) {
      throw new IllegalArgumentException("Bad time values");
    }
    this.xPos = x;
    this.yPos = y;
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.name = n;
    this.startTime = s;
    this.endTime = e;
  }

  @Override
  public void changeColor(float r, float g, float b) {
    this.red = r;
    this.green = g;
    this.blue = b;
  }

  //Can't define this here since a ADrawable does not have any definition of size
  @Override
  public abstract void scale(double desiredX, double desiredY);


  //Getters for fields
  public String getName() {
    return this.name;
  }

  public double getX() {
    return this.xPos;
  }

  public double getY() {
    return this.yPos;
  }

  /**
   * Returns the width of this drawable object.
   *
   * @return the width of this
   */
  public abstract double getWidth();

  /**
   * Returns the height of this drawable object.
   *
   * @return the height of this
   */
  public abstract double getHeight();

  @Override
  public void move(float x, float y) {
    this.xPos = x;
    this.yPos = y;
  }

  @Override
  public abstract IDrawable changeShape(DrawableType type);
}

