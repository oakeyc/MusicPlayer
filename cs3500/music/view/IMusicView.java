package cs3500.music.view;

import java.awt.*;
import java.awt.event.KeyListener;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.controller.MouseHandler;
import cs3500.music.model.Note;
import cs3500.music.model.Song;
import cs3500.music.view.gui.ScrollDir;

/**
 * Interface that represents A view.
 * Created by Courtney on 6/13/2016.
 */
public interface IMusicView {
  /**
   * Sets the model for the view based on an model given as input.
   * @param model
   */
  void setModel(Song.Builder model);

  /**
   * Method for rendering the view
   * Displays either text, gui, or midi output.
   * @return
   */
  void render();

  /**
   * stops the view from presenting more
   */
  void playPause();

  void addKeyLis(KeyListener kbd); // FIXME: 6/24/2016

  void scroll(ScrollDir left);

  void addMouseLis(MouseHandler msh);

  Note getInputNote();
}
