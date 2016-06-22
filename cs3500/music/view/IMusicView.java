package cs3500.music.view;

import java.awt.*;

import cs3500.music.model.Song;

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
  void stop();
}
