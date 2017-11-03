import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import cs3500.animator.drawables.ADrawable;
import cs3500.animator.drawables.Oval;
import cs3500.animator.drawables.Rectangle;
import cs3500.animator.commands.ACommand;
import cs3500.animator.model.Animation;
import cs3500.animator.commands.MoveCommand;
import cs3500.animator.commands.ScaleCommand;

public class AnimationTest {
  ADrawable c1 = new Oval(50.0, 100, 100, Color.BLACK, "Circle1", 0, 100);
  ADrawable c2 = new Oval(25.0, 100, 100, Color.RED, "Circle2", 0, 100);
  ADrawable r1 = new Rectangle(500.0, 200.0, 0, 20, Color.GREEN,
          "Rec1",0, 100);
  ADrawable r2 = new Rectangle(1600.0, 200.0, 0, 20, Color.BLUE, "Rec2",
          0, 100);

  ACommand move1 = new MoveCommand(c1, 0, 30, 100, 50);
  ACommand move2 = new MoveCommand(c2, 30, 50, 100, 100);
  ACommand move3 = new MoveCommand(r1, 0, 20, 25, 50);
  ACommand move4 = new MoveCommand(r1, 0, 10, 25, 20);
  ACommand move5 = new MoveCommand(r1, 30, 50, 100, 100);
  ACommand scale1 = new ScaleCommand(c2, 0, 20, 15, 35);
  ACommand scale2 = new ScaleCommand(r2, 0, 20, 50, 20);

  ArrayList<ADrawable> drawables = new ArrayList<ADrawable>();
  ArrayList<ACommand> commands = new ArrayList<ACommand>();
  ArrayList<ACommand> comparison = new ArrayList<ACommand>();

  Animation model = new Animation(0, 100, drawables, commands);

  /**
   * Initializes values for testing.
   */
  @Before
  public void initialize() {
    this.drawables.clear();
    this.commands.clear();
    this.comparison.clear();
    this.drawables.add(c1);
    this.drawables.add(c2);
    this.drawables.add(r1);
    this.drawables.add(r2);
    this.comparison.add(move1);
    this.comparison.add(move3);
    this.comparison.add(scale1);
    this.comparison.add(scale2);
    this.comparison.add(move2);
    this.comparison.add(move5);
    model.addCommand(move1);
    model.addCommand(move2);
    model.addCommand(move3);
    model.addCommand(scale1);
    model.addCommand(scale2);

  }

  @Test
  public void testToString() {
    assertEquals(this.model.toString(), "Shapes:\nName: Circle1"
            + "\nType: Oval\nCenter: (100,100),"
            + " X Radius: 50.0, Y Radius: 50.0, Color: (0,0,0)\nAppears at t = 0\nDisappears"
            + " at t = 100\nName: Circle2\nType: Oval\nCenter: (100,100), X Radius: 25.0"
            + ", Y Radius: 25.0, Color: (255,0,0)\nAppears at t = 0\nDisappears at t = 100"
            + "\nName: Rec1\nType: Rectangle\nCenter: (0,20), Width: 500.0"
            + ", Height: 200.0, Color: (0,255,0)\nAppears at t = 0\nDisappears at t = 100"
            + "\nName: Rec2\nType: Rectangle\nCenter: (0,20), Width: 1600.0"
            + ", Height: 200.0, Color: (0,0,255)\nAppears at t = 0\nDisappears at t = 100"
            + "\nShape Circle1 moves from (100,100) to (100,50) from t = 0 to t = 30"
            + "\nShape Rec1 moves from (0,20) to (25,50) from t = 0 to t = 20"
            + "\nShape Circle2 scales from Width: 50.0, Height: 50.0 to Width: 15.0, Height: 35.0 "
            + "from t = 0 to t = 20\nShape Rec2 scales from Width: 1600.0, Height: 200.0"
            + " to Width: 50.0, Height: 20.0 from t = 0 to t = 20"
            + "\nShape Circle2 moves from (100,100) to (100,100) from t = 30 to t = 50");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddCommand() {
    model.addCommand(move4);
  }

  @Test
  public void testAddCommand2() {
    model.addCommand(move5);
    assertEquals(model.getCommands(), this.comparison);
  }
}