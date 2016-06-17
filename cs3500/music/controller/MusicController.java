package cs3500.music.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.music.model.Beat;
import cs3500.music.model.GenericMusicModel;
import cs3500.music.model.Song;
import cs3500.music.view.IMusicView;
import cs3500.music.view.TextView;

/**
 * Primary controller class.
 * Controller has a Model and a View that it runs.
 *
 * Created by Courtney on 6/7/2016.
 */
public class MusicController {
    Song.Builder model;
    IMusicView view;

  /**
   * Creates an instance of MusicController
   * @param model
   * @param view
   */
  public MusicController(Song.Builder model, IMusicView view) {
        this.model = model;
        this.view = view;
    }

  /**
   * Sets the model of the given view.
   */
  public void modelToView() {
        view.setModel(model);
    }

  /**
   * primary play method called by MusicEditor,
   * calls render() in respective view.
   */
  public void play() {
        view.render();
    }

}
