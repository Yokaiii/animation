package cs3500.animator.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

import cs3500.animator.commands.ACommand;
import cs3500.animator.commands.ColorChangeCommand;
import cs3500.animator.commands.MoveCommand;
import cs3500.animator.commands.ScaleCommand;
import cs3500.animator.drawables.ADrawable;
import cs3500.animator.drawables.Oval;
import cs3500.animator.drawables.Rectangle;
import cs3500.animator.views.TweenModelBuilder;
import cs3500.animator.views.AnimationFileReader;


/**
 * Representation of an animation of a single drawable object with a start time and a end time.
 */
public class Animation implements IAnimation {

  //The start time for this specific animation (int because it isn't a set timescale)
  //private final int startTime;
  //The end time for this animation (int because it isn't a set timescale)
  //private final int endTime;
  //The objects to animate
  private final ArrayList<ADrawable> drawables;
  //Commands to perform on the drawables
  private final ArrayList<ACommand> commands;
  private final AnimationFileReader reader;
  private final Builder builder;

  /**
   * Constructor for an Animation.
   *
   * @param s the start time for this animation
   * @param e the end time for this animation
   * @param d the drawable objects in this animation
   * @param c the commands to execute on the drawables
   */
  public Animation(ArrayList<ADrawable> d, ArrayList<ACommand> c) {
    if (d == null || c == null) {
      throw new IllegalArgumentException("Cannot animate nulls");
    }
    //this.startTime = s;
    //this.endTime = e;
    this.drawables = d;
    this.commands = c;
    this.reader = new AnimationFileReader();
  }

  /**
   * Constructor for an animation that takes in a file for all the information
   */
  public Animation(String fileName) {
    this.reader = new AnimationFileReader();
    this.builder = new Builder();
    try {
      reader.readFile(fileName, this.builder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    String result = "Shapes:";
    for (ADrawable drawable : this.drawables) {
      result += "\n" + drawable.toString();
    }
    for (ACommand command : this.commands) {
      result += "\n" + command.toString();
    }
    return result;
  }

  @Override
  public void addCommand(ACommand command) {
    if (this.checkValidity(command)) {
      this.commands.add(command);
      Collections.sort(this.commands);
    } else {
      throw new IllegalArgumentException("Cannot add conflicting command");
    }
  }

  /**
   * Checks if the given command can fit into this animation's list of commands to execute,
   * determined by whether there is a command of the same type occuring at the same time.
   *
   * @param command the command to check validity
   * @return whether command is valid
   */
  private boolean checkValidity(ACommand command) {
    for (ACommand c : this.commands) {
      if (c.getClass().equals(command.getClass())) {
        if (c.conflict(command)) {
          return false;
        }
      }
      //check if the command even fits into this animation time wise
      if (!(command.fitInTimeFrame(this.startTime, this.endTime))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void addDrawable(ADrawable drawable) {
    this.drawables.add(drawable);
  }

  /**
   * Getter for the list of commands in this animation.
   *
   * @return the commands to be exectuted in this animation
   */
  public ArrayList<ACommand> getCommands() {
    return this.commands;
  }

  public void updateOffTime(long currentTime, int speed) {
    for (ACommand cmd : this.commands) {
      if ((cmd.startTime() <= currentTime / speed) && (cmd.endTime() >= currentTime / speed)) {
      cmd.calculate(currentTime);
    }
  }


  public static final class Builder implements TweenModelBuilder<Animation> {

    private ArrayList<ADrawable> drawablesBuild;
    private ArrayList<ACommand> commandsBuild;

    @Override
    public TweenModelBuilder<Animation> addOval(String name, float cx, float cy,
                                                float xRadius, float yRadius,
                                                float red, float green, float blue,
                                                int startOfLife, int endOfLife) {

      this.drawablesBuild.add(new Oval(xRadius, yRadius, cx, cy, red, green, blue,
              name, startOfLife, endOfLife));
      return this;
    }

    @Override
    public TweenModelBuilder<Animation> addRectangle(String name, float lx, float ly,
                                                     float width, float height,
                                                     float red, float green, float blue,
                                                     int startOfLife, int endOfLife) {
      this.drawablesBuild.add(new Rectangle(width, height, lx, ly, red, green, blue,
              name, startOfLife, endOfLife));
      return this;
    }

    @Override
    public TweenModelBuilder<Animation> addMove(String name, float moveFromX, float moveFromY,
                                                float moveToX, float moveToY,
                                                int startTime, int endTime) {
      this.commandsBuild.add(new MoveCommand(getDrawable(name), startTime, endTime, moveToX, moveToY));
      return this;
    }

    @Override
    public TweenModelBuilder<Animation> addColorChange(String name,
                                                       float oldR, float oldG, float oldB,
                                                       float newR, float newG, float newB,
                                                       int startTime, int endTime) {
      this.commandsBuild.add(new ColorChangeCommand(getDrawable(name),
              oldR, oldG, oldB, newR, newG, newB, startTime, endTime));
      return this;
    }

    @Override
    public TweenModelBuilder<Animation> addScaleToChange(String name, float fromSx, float fromSy,
                                                         float toSx, float toSy,
                                                         int startTime, int endTime) {
      this.commandsBuild.add(new ScaleCommand(getDrawable(name), fromSx, fromSy, toSx, toSy,
              startTime, endTime));
      return this;
    }

    @Override
    public Animation build() {
      //fix this (find out what the start/end should be
      return new Animation(1, 2 this.drawablesBuild, this.commandsBuild);

    }

    private ADrawable getDrawable(String name) {
      for (ADrawable d : this.drawablesBuild) {
        if (d.getName().equals(name)) {
          return d;
        }
      }
      throw new IllegalArgumentException("Cannot find this drawable object");
    }
  }
}
