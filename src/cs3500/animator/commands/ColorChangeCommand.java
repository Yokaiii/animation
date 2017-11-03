package cs3500.animator.commands;

import cs3500.animator.drawables.ADrawable;

import java.awt.Color;

public class ColorChangeCommand extends ACommand {
  private final float beforeRed;
  private final float beforeGreen;
  private final float beforeBlue;
  private final float toRed;
  private final float toGreen;
  private final float toBlue;

  public ColorChangeCommand(ADrawable t, float fr, float fg, float fb, float tr, float tg, float tb,
                            int start, int end) {
    super(t, start, end);
    this.beforeRed = fr;
    this.beforeGreen = fg;
    this.beforeBlue = fb;
    this.toRed = tr;
    this.toGreen = tg;
    this.toBlue = tb;
  }

  @Override
  public void execute() {
    this.target.changeColor(this.toRed,
            this.toGreen, this.toBlue);
  }



  public void calculate(long current) {
    target.changeColor(calculateValue(current, this.beforeRed, this.toRed),
            calculateValue(current, this.beforeGreen, this.toGreen),
            calculateValue(current, this.beforeBlue, this.toBlue));
  }
}
