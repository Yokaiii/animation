package cs3500.animator.views;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import cs3500.animator.views.IView;
import cs3500.animator.commands.ACommand;
import cs3500.animator.drawables.ADrawable;

public class TweenView extends JFrame implements IView, ActionListener {

  private final Timer theTimer;
  private long currentTime;
  private ArrayList<ADrawable> shapes;
  private ArrayList<ACommand> commands;

  public TweenView(int speed) {
    this.theTimer = new Timer(speed, this);
    this.currentTime = 0;

    this.setTitle("Animation");
    this.setSize(x, y);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  //every tick, look at each command

  /*
  Every tick look at each command
  say Move("R" 200 500)
  figure out what values to set
  @currenttime figure out values
  draw shape with those values substituted in


  public void actionPerformed(ActionEvent e) {
    currentTime = e.getWhen();
    for (ACommand cmd : this.commands)  {
      cmd.calculate(currentTime);
    }
    repaint();
  }*/

  /**
   * Everytime it refreshes it should run the equation
   */
  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public void go() {
    this.theTimer.start();
    this.makeVisible();
  }

  public long getTime() {
    return this.currentTime;
  }
}
