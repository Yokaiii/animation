package cs3500.animator.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import cs3500.animator.model.IAnimation;
import cs3500.animator.views.TweenView;

public class Controller implements ActionListener {
  IAnimation model;
  TweenView view;
  Timer timer;
  long currentTime;
  private final int speed;

  Controller(IAnimation m, TweenView t, int speed) {
    this.model = m;
    this.view = t;
    this.speed = 1000 / speed;
    this.timer = new Timer(this.speed, this);
    this.currentTime = 0;
  }

  public void actionPerformed(ActionEvent e) {
    currentTime = e.getWhen();
    model.updateOffTime(currentTime, this.speed);
  }

  public void go() {
    this.timer.start();
    view.go();
  }

}
