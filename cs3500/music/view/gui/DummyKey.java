package cs3500.music.view.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * Created by Ian Leonard on 6/24/2016.
 */
public class DummyKey implements KeyListener {
  Timer t;
  JFrame f;
  int m;

  public DummyKey(Timer t) {
    f = new JFrame();
    f.setSize(500, 500);
    f.addKeyListener(this);
    m = 0;
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setVisible(true);
    this.t = t;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
    public void keyPressed(KeyEvent e) {
        t.stop();

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  public static void main(String[] args) {

  }
}
