import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.awt.Color;

import cs3500.animator.drawables.ADrawable;
import cs3500.animator.drawables.Oval;
import cs3500.animator.drawables.Rectangle;
import cs3500.animator.drawables.DrawableType;

public class IDrawableTest {

  ADrawable c1 = new Oval(50.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
  ADrawable c2 = new Oval(25.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
  ADrawable c3 = new Oval(50.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
  ADrawable c4 = new Oval(12.5, 65.0, 100, 100, Color.BLACK, "Circle1", 0,
          20);
  ADrawable c5 = new Oval(50.0, 100, 100, Color.RED, "Circle1", 0, 20);

  ADrawable r1 = new Rectangle(500.0, 200.0, 0, 20, Color.BLACK,
          "rec1",0, 20);
  ADrawable r2 = new Rectangle(1600.0, 200.0, 0, 20, Color.BLACK,
          "rec1", 0, 20);
  ADrawable r2c = new Oval(800.0, 100.0, 0, 20, Color.BLACK, "rec1",
          0, 20);

  /**
   * To initialize values for testing.
   */
  @Before
    public void initialize() {
    c1 = new Oval(50.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
    c2 = new Oval(25.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
    c3 = new Oval(50.0, 100, 100, Color.BLACK, "Circle1", 0, 20);
    c4 = new Oval(12.5, 65, 100, 100, Color.BLACK, "Circle1", 0, 20);
    c5 = new Oval(50.0, 100, 100, Color.RED, "Circle1", 0, 20);
  }

  @Test
  public void testScale1() {
    c1.scale(25.0, 25.0);
    assertEquals(c1, c2);
  }

  @Test
  public void testScale2() {
    c1.scale(50.0, 50.0);
    assertEquals(c1, c3);
  }

  @Test
  public void testScale3() {
    c2.scale(50.0, 50.0);
    assertEquals(c2, c1);
  }

  /*
  @Test
  public void testScale4() {
    c1.scale(0.25, 1.3);
    assertEquals(c1, c4);
  }

  @Test
  public void testScale5() {
    c1.scale(0.0, 0.0);
    assertEquals(c1, c3);
  }

  @Test
  public void testScale6() {
    c1.scale(-1.43, -5000);
    assertEquals(c1, c3);
  }
  */

  @Test
  public void testChangeColor1() {
    c1.changeColor(Color.RED);
    assertEquals(c1, c5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    ADrawable bad = new Oval(50.0, 50, 50, null,
            null, 50, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    ADrawable bad = new Oval(50.0, 50, 50, Color.RED, "ASDF", 60, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    ADrawable bad = new Oval(50.0, 50, 50, Color.RED, "ASDF", -5, 50);
  }

  //Rectangle -> Oval
  @Test
  public void testChangeShape() {
    assertEquals(this.r2.changeShape(DrawableType.OVAL), this.r2c);
  }

  //Oval -> Rectangle
  @Test
  public void testChangeShape2() {
    assertEquals(this.r2c.changeShape(DrawableType.RECTANGLE), this.r2);
  }
}