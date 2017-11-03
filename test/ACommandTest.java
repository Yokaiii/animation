import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import cs3500.animator.commands.ACommand;
import cs3500.animator.commands.MoveCommand;
import cs3500.animator.commands.ScaleCommand;
import cs3500.animator.drawables.ADrawable;
import cs3500.animator.drawables.Oval;
import cs3500.animator.drawables.Rectangle;
import java.awt.Color;

public class ACommandTest {

  ADrawable circle1 = new Oval(25.0, 50, 50, Color.BLUE, "Circle 1",0, 50);
  ADrawable rec1 = new Rectangle(20, 50, 50, 25,
          Color.RED,"Rectangle 1", 0, 50);
  ACommand move1 = new MoveCommand(circle1, 0, 30, 100, 50);
  ACommand move2 = new MoveCommand(circle1, 30, 50, 100, 100);
  ACommand move3 = new MoveCommand(rec1, 0, 20, 25, 50);
  ACommand scale1 = new ScaleCommand(circle1, 0, 20, 15, 35);
  ACommand scale2 = new ScaleCommand(rec1, 0, 20, 50, 20);

  /**
   * To initialize values for testing.
   */
  @Before
  public void initialize() {
    circle1 = new Oval(25.0, 50, 50, Color.BLUE, "Circle 1",0, 50);
    rec1 = new Rectangle(20, 50, 50, 25,
            Color.RED,"Rectangle 1", 0, 50);
    move1 = new MoveCommand(circle1, 0, 30, 100, 50);
    move2 = new MoveCommand(circle1, 30, 50, 100, 100);
    move3 = new MoveCommand(rec1, 0, 20, 25, 50);
    scale1 = new ScaleCommand(circle1, 0, 20, 15, 35);
    scale2 = new ScaleCommand(rec1, 0, 20, 50, 20);
  }

  @Test
  public void testMoveCommand1() {
    move1.execute();
    assertEquals(circle1.getX(), 100);
    assertEquals(circle1.getY(), 50);
  }

  @Test
  public void testMoveCommand2() {
    move2.execute();
    assertEquals(circle1.getX(), 100);
    assertEquals(circle1.getY(), 100);
  }

  @Test
  public void testMoveCommand3() {
    move3.execute();
    assertEquals(rec1.getX(), 25);
    assertEquals(rec1.getY(), 50);
  }

  @Test
  public void testScaleCommand1() {
    scale1.execute();
    assertEquals(circle1.getWidth(), 30, 0.000001);
    assertEquals(circle1.getHeight(), 70, 0.000001);
  }

  @Test
  public void testScaleCommand2() {
    scale2.execute();
    assertEquals(rec1.getWidth(), 50, 0.000001);
    assertEquals(rec1.getHeight(), 20, 0.000001);
  }

  @Test
  public void testToString1() {
    assertEquals(move1.toString(), "Shape Circle 1 moves from (50,50) to "
            + "(100,50) from t = 0 to t = 30");
  }

  @Test
  public void testToString2() {
    assertEquals(move2.toString(), "Shape Circle 1 moves from (50,50) to "
            + "(100,100) from t = 30 to t = 50");
  }

  @Test
  public void testToString3() {
    assertEquals(move3.toString(), "Shape Rectangle 1 moves from (50,25)"
            + " to (25,50) from t = 0 to t = 20");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    ACommand illegalMove = new MoveCommand(null, 0, 30, 100, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    ACommand illegalMove = new MoveCommand(circle1, -5, 30, 100, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    ACommand illegalMove = new MoveCommand(circle1, 50, 30, 100, 50);
  }
}